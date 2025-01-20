import java.util.*;
import java.util.function.Function;
class Solution
{
    final static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) throws Exception
    {
        int T = sc.nextInt();
        for (int t=1;t<=T;t++) {
            System.out.println("#" + t + " " + run());
        }
    }
    private static Queue<int[]> pq = new PriorityQueue<>(Comparator.comparing(item->item[2]));
    private static String run() {
    	// 22980 삼각형 만들기
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int k = sc.nextInt();
        int all = (k+1)*(k+2)*(k+3)/6;
        int aDiff = a-b-c;
        int bDiff = b-a-c;
        int cDiff = c-a-b;
        if (k+aDiff>0) all-=calcCase(k+aDiff);
        if (k+bDiff>0) all-=calcCase(k+bDiff);
        if (k+cDiff>0) all-=calcCase(k+cDiff);
        return String.valueOf(all);
    }
    // 중복조합
    private static int calcCase(int inp) {
    	int sum=0;
    	for (int i=0;i<inp+1;i++) {
    		sum+=(inp-i+1)*(inp-i+2)/2;
    	}
    	return sum;
    }
      
}