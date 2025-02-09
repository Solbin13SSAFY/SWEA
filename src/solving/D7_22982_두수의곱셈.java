import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D7_22982_두수의곱셈 {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws NumberFormatException, IOException {
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for (int t=1;t<=T;t++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int p = Integer.parseInt(st.nextToken());
			
			// step 1 : 1을 이용하여 0을 만든다.
			// 4번 레지스터부터 차례대로 2,4,8 ....을 저장한다.
			int pow = rt(p);
			for (int i=4;i<pow+4;i++) {
				sb.append("+ " + (i-1) + " " + (i-1) + " " + i + "\n");
			}
			// 100번 레지스터에 0을 저장한다.
			for (int i=1;i<=pow;i++) {
				if ((p&(1<<i))!=0) {
					sb.append("+ " + (i+3) + " 100 100\n");
				}
			}
			
			// step 2 : y(p-1) = -y (mod p)
			// 2번 레지스터부터 차례대로 y,2y, 4y, 8y ....을 저장한다.
			pow = rt(p-1);
			for (int i=3;i<pow+3;i++) {
				sb.append("+ " + (i-1) + " " + (i-1) + " " + i + "\n");
			}
			// 99번 레지스터에 x-y를 저장한다.
			sb.append("+ 1 100 99\n");
			for (int i=1;i<=pow;i++) {
				if (((p-1)&(1<<i))!=0) {
					sb.append("+ " + (i+2) + " 99 99\n");
				}
			}
			
			// step 3 : (x+y)^(p+1) = (x+y)^2 (mod p)
			//          (x-y)^(p+1) = (x-y)^2 (mod p)
			// 98번 레지스터에 x+y 를 저장한다
			sb.append("+ 1 2 98\n");
			// n mod p-1 = 2 를 만족하는 (x+y)^n이 나올 때 까지 k제곱을 반복한다.
			int cnt = k;
			sb.append("^ 98 98\n");
			sb.append("^ 99 99\n");
			// TODO 여기서 무한루프 돌 가능성이 크다. 시간,메모리 초과 나면 여기 때문일듯.
			if (p>3) {				
				while (cnt%(p-1)!=2) {
					cnt*=k;
					sb.append("^ 98 98\n");
					sb.append("^ 99 99\n");
				}
			}
			
			// step 4 : (x+y)^2 - (x-y)^2 = 4xy (mod p)
			// 3번 레지스터부터 차례대로 (x-y)^2, 2(x-y)^2, 4(x-y)^2 .... 을 저장한다.
			sb.append("+ 99 100 3\n");
			pow = rt(p-1);
			for (int i=4;i<pow+4;i++) {
				sb.append("+ " + (i-1) + " " + (i-1) + " " + i + "\n");
			}
			// 97번 레지스터에 -(x-y)^2를 저장한다.
			sb.append("+ 100 100 97\n");
			for (int i=1;i<=pow;i++) {
				if (((p-1)&(1<<i))!=0) {
					sb.append("+ " + (i+3) + " 97 97\n");
				}
			}
			
			// step 5 : (x+y)^2 - (x-y)^2 = 4xy (mod p)
			// 3번 레지스터에 4xy를 저장한다
			sb.append("+ 98 97 3\n");
			
			// 적절한 값을 곱해서 xy로 만든다.
			// 여기서도 무한루프 돌 가능성이 있음. 그럴 때는 4*a-p를 이용하여 새로운 수를 만들어보자.
			int tmp = p;
			while (tmp%4!=3) {
				tmp+=2*p;
			}
			tmp = (tmp+1)/4;
			pow = rt(tmp);
			// 3번 레지스터부터 차례대로 4xy, 8xy, 16xy .... 을 저장한다.
			for (int i=4;i<pow+4;i++) {
				sb.append("+ " + (i-1) + " " + (i-1) + " " + i + "\n");
			}
			// 96번 레지스터에 xy를 저장한다.
			sb.append("+ 100 100 96\n");
			for (int i=0;i<=pow;i++) {
				if ((tmp&(1<<i))!=0) {
					sb.append("+ " + (i+4) + " 96 96\n");
				}
			}
			// xy를 출력한다/
			sb.append("! 96\n");
		}
		System.out.println(sb);
	}
	
	static int rt(int n) {
		return Integer.numberOfTrailingZeros(Integer.highestOneBit(n));
	}
}
