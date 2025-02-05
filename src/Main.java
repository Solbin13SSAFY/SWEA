import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringBuilder sb = new StringBuilder();
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		int n = Integer.parseInt(br.readLine());
		boolean[][] arr= new boolean[n][n];
		StringTokenizer st;
		for (int i=0;i<n;i++) {
			st = new StringTokenizer(br.readLine());
			for (int j=0;j<n;j++) {
				arr[i][j] = st.nextToken()=="1"?true:false;
			}
		}
		int size = cut(arr);
		
		System.out.println(sb);
	}
	
	static int cut(boolean[][] arr) {
		return 0;
	}
	
	static int getSize(int n) {
		return Integer.numberOfTrailingZeros(n);
	}
}