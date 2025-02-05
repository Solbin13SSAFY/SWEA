package solved;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Solution {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main (String[] args) throws NumberFormatException, IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t=1;t<=T;t++) {
            String[] arr = br.readLine().split(" ");
            int a = Integer.parseInt(arr[0]);
            int b = Integer.parseInt(arr[1]);
            int c = Integer.parseInt(arr[2]);
            int k = Integer.parseInt(arr[3]);
            long all = (long)(k+1)*(k+2)*(k+3)/6;
            all-=calcCombSum(a-b-c,k);
            all-=calcCombSum(b-c-a,k);
            all-=calcCombSum(c-a-b,k);
            System.out.println(all);
        }
    }
    public static long calcCombSum (int diff, int k) {
        long sum=0;
        for (int i=k;i>=-diff&&i>=0;i--) {
            long mm=k>diff+2*i?diff+i:k-i;           
            sum+=(mm+1)*(mm+2)/2;
        }
        return sum;
    }
}