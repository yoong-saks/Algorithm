import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	private static int[][] map = new int[100][100];
	private static boolean[][] visited;
	
	private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	private static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int t = 1; t <= 10; ++t) {
			int T = Integer.parseInt(br.readLine());
			
			ans = 0;
			visited = new boolean[100][100];
			
			int startI = 0;
			int startJ = 0;
			
			for(int i = 0; i < 100; ++i) {
				String s = br.readLine();
				for(int j = 0; j < 100; ++j) {
					map[i][j] = s.charAt(j) - '0';
					
					if(map[i][j] == 2) {
						startI = i;
						startJ = j;
					}
				}
			}
			
			dfs(startI, startJ);
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	private static void dfs(int i, int j) {
		if(ans == 1) return;
		
		if(map[i][j] == 3) {
			ans = 1;
			
			return;
		}
		visited[i][j] = true;
		
		for(int d = 0; d < 4; ++d) {
			int ni = i + dir[d][0];
			int nj = j + dir[d][1];
			
			if(!(0 <= ni && ni < 100) || !(0 <= nj && nj < 100)) continue;
			if(map[ni][nj] == 1) continue;
			if(visited[ni][nj]) continue;
			
			dfs(ni, nj);
		}
	}
}
