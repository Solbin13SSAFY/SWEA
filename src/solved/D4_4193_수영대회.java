package solved;
import java.util.*;
 
public class D4_4193_수영대회 {
	final static Scanner sc = new Scanner(System.in);
	public static void main (String[] args) {
		int T = sc.nextInt();
		for (int t= 1; t<= T; t++) {
			System.out.println("#" + t + " " + run());
		}
	}
	private static int n;
	private static int min;
	static int fx;
	static int fy;
	static Queue<int[]> pq = new LinkedList<>();
	private static String run() {
		n = sc.nextInt();
		min = -1;
		pq.clear();
		int[][] arr = new int[n][n];
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		int x = sc.nextInt();
		int y = sc.nextInt();
		fx = sc.nextInt();
		fy = sc.nextInt();
		pq.add(new int[]{x,y,0});
		while (!pq.isEmpty()) {
			int[] qe = pq.poll();
			move(arr,qe[0],qe[1],qe[2]);
		}
		return String.valueOf(min);
	}
	private static void move(int[][] arr, int x, int y, int tt) {
		if (arr[x][y] == 2&&tt%3!=0) {
			pq.add(new int[] {x,y,++tt});
			return;
		}
		if (x==fx&&y==fy) {
			if (min==-1||min>tt) min=tt;
			return;
		}
		arr[x][y] = 1;
		int[] dx = new int[] {-1,1,0,0};
		int[] dy = new int[] {0,0,-1,1};
		tt++;
		for (int i=0;i<4;i++) {
			if (bound(x+dx[i],y+dy[i],arr)) pq.add(new int[] {x+dx[i],y+dy[i],tt});
		}
	}
	private static boolean bound(int x,int y,int[][] arr) {
		return (!(x<0||x>=n||y<0||y>=n)&&arr[x][y]!=1);
	}
}