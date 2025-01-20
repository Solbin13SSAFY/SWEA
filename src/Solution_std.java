import java.util.*;
class Solution_std
{
    final static Scanner sc = new Scanner(System.in);
    public static void main(String args[]) throws Exception
    {
        int T = sc.nextInt();
        for (int t=1;t<=T;t++) {
            System.out.println("#" + t + " " + run());
        }
    }
 
    private static String run() {
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0;i<n;i++) {
        	arr[i] = sc.nextInt();
        }
        return null;
    }
}