
import java.util.Scanner;
 
public class Solution_std {
	final static Scanner sc = new Scanner(System.in);
    public static void main (String[] args) {
        int T = sc.nextInt();
        for (int t=1;t<=T;t++) {
            System.out.println("#" + t + " " + run());
        }
    }
    public static String run() {
    	int k = sc.nextInt();
    	int c0 = sc.nextInt();
    	int c1 = sc.nextInt();
    	int c2 = sc.nextInt();
    	int c3 = sc.nextInt();
    	int c4 = sc.nextInt();
    	int c5 = sc.nextInt();
    	for (int n=0;n<=999999;n++) {
    		int b0=0,b1=0,b2=0,b3=0,b4=0,b5=0;
    		for (int i=0;i<calcComb(n,k);i++) {
    			short iShort = convByte(i);
    			
    		}
    	}
    	
    	return null;
    }

    public static long calcComb(int n, int k) {
        long[][] dp = new long[n+1][k+1];
        for (int i=0;i<=n;i++) {
            for (int j=0;j<=Math.min(i,k);j++) {
                if (j==0||j==i) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }
            }
        }
        return dp[n][k];
    }

    
    public static short convByte(int k) {
    	short s=0;
    	while (k>0) {
    		byte b = (byte)((k%10)/3);
    		s = (short)(s<<2|b);
    		k/=10;
    	}
    	return s;
    }
}
