package solving;
import java.util.Scanner;
public class D7_22797_거의같게만들기 {
	final static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		int T = sc.nextInt();
		for (int t=1;t<=T;t++) {
			run();
		}
	}
	public static void run() {
		int n = sc.nextInt();
		int fstPow = Integer.numberOfTrailingZeros(Integer.highestOneBit(n-1));
		int remains = n-(1<<fstPow);
		int sndPow = 0;
		if (remains>1) {
			sndPow = Integer.numberOfTrailingZeros(Integer.highestOneBit((remains-1)<<1));
		}
		System.out.print((1<<(fstPow-1))*fstPow+(1<<(sndPow-1))*sndPow);
		for (int i=0;i<fstPow;i++) {
			for (int j=0;j<(1<<(fstPow-1-i));j++) {
				for (int k=0;k<(1<<i);k++) {
					int a1 = 1+j*(1<<(i+1))+k;
					int a2 = 1+j*(1<<(i+1))+(1<<i)+k; 
					System.out.print(" " + a1 + " " + a2);
				}
			}
		}
		for (int i=0;i<sndPow;i++) {
			int point = n-(1<<sndPow);
			for (int j=0;j<(1<<(sndPow-1-i));j++) {
				for (int k=0;k<(1<<i);k++) {
					int a1 = point+1+j*(1<<(i+1))+k;
					int a2 = point+1+j*(1<<(i+1))+(1<<i)+k; 
					System.out.print(" " + a1 + " " + a2);
				}
			}
		}
		System.out.println();
	}
}
