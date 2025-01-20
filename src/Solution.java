public class Solution {
    public static void main(String[] args) {
        int n = 5; // 분할하려는 자연수
        int k = 3; // 음이 아닌 정수의 개수

        int[] partition = new int[k]; // 분할 결과를 저장할 배열
        partition(n, k, partition, 0);
    }
    
    // 분할 결과를 저장하고 출력하는 함수
    public static void printPartition(int[] partition) {
        for (int num : partition) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    // n을 k개의 음이 아닌 정수로 분할하는 함수
    public static void partition(int n, int k, int[] partition, int index) {
        if (k == 1) {
            partition[index] = n;
            printPartition(partition);
            return;
        }
        
        for (int i = 0; i <= n; i++) {
            partition[index] = i;
            partition(n - i, k - 1, partition, index + 1);
        }
    }
}
