import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private static int[][] map = new int[20][20];
	private static boolean[] dessert = new boolean[100];
	private static int[][] visited;
	private static int[][] dir = {{-1, -1}, {-1, 1}, {1, 1}, {1, -1}};
	private static int N, ans, startI, startJ;
	
	public static void main(String[] args) throws Exception {
		//System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			N = Integer.parseInt(br.readLine());
			
			visited = new int[20][20];
			ans = -1;
			
			for(int i = 0; i < N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					startI = i;
					startJ = j;
					Arrays.fill(dessert, false);

					dfs(startI, startJ, 0, 0, 0);
				}
			}
			if(ans < 4) ans = -1;
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	private static void dfs(int i, int j, int cnt, int d, int depth) {
		visited[i][j] = startI * N + startJ + 1;
		dessert[map[i][j] - 1] = true;
		
		if(cnt == 3 && i == startI && j == startJ) {
			ans = Math.max(ans, depth);
			visited[i][j] = startI * N + startJ;
			return;
		}
		
		for(int dd = d; dd <= d + 1; dd++) {
			int ni = i + dir[dd % 4][0];
			int nj = j + dir[dd % 4][1];
			
			if(!(0 <= ni && ni < N) || !(0 <= nj && nj < N)) continue;
			if(!(ni == startI && nj == startJ) && dessert[map[ni][nj] - 1]) continue;
			if(!(ni == startI && nj == startJ) && visited[ni][nj] == startI * N + startJ + 1) continue;
			
			dfs(ni, nj, cnt + (dd == d ? 0 : 1), dd % 4, depth + 1);
		}
		
		visited[i][j] = startI * N + startJ;
		dessert[map[i][j] - 1] = false;
	}
}
