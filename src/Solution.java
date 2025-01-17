import java.util.Scanner;
 
public class Solution {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int leng = str.length();
        int sum = 0;
        for (int i=0;i<leng;i++) {
            int num = Integer.parseInt(String.valueOf(str.charAt(i)));
            sum += num;
        }
        print(sum);
        scanner.close();
    }
     
    public static void print(Object obj) {
        System.out.println(obj);
    }
}