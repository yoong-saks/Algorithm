import java.util.Scanner;

public class Solution {
	private static int ans, N;
	
	private static boolean[] col;
	private static boolean[] s;
	private static boolean[] bs;
	
//	private int colB;
//	private int sB;
//	private int bsB;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; ++t) {
			N = sc.nextInt();
			
			ans = 0;
			col = new boolean[N + 1];
			s = new boolean[2 * N];
			bs = new boolean[2 * N];
			
			dfs(1);
			System.out.println("#" + t + " " + ans);
		}
	}
	
	private static void dfs(int row) {
		if(row > N) {
			ans++;
			return;
		}
		
		for(int c = 1; c <= N; ++c) {
			//유망성 체크
			if(col[c] || s[row + c - 1] || bs[row - c + N]) continue;
			
			col[c] = s[row + c - 1] = bs[row - c + N] = true;
			dfs(row + 1);
			col[c] = s[row + c - 1] = bs[row - c + N] = false;
		}
		
	}
}
