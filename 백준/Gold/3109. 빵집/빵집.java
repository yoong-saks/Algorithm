import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static char[][] map = new char[10_000][500];
	
	private static int[][] directions = { {-1, 1}, {0, 1}, {1, 1} };
	private static int ans, R, C;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken()); // 1 <= 10_000
		C = Integer.parseInt(st.nextToken()); // 5 <= 500
		
		for(int i = 0; i < R; ++i) {
			String s = br.readLine();
			for(int j = 0; j < C; ++j) {
				map[i][j] = s.charAt(j);
			}
		}
		
		//우상, 우, 우하 순으로 이동
		//0 ~ R - 1으로 dfs. 끝까지 도달하면 ans + 1. 도달 못하고 이동 못하면 끝
		for(int i = 0; i < R; ++i) {
			dfs(i, 0);
		}
		System.out.println(ans);
	}
	
	private static boolean dfs(int r, int c) {
		map[r][c] = 'x';
		
		for(int d = 0; d < 3; ++d) {
			int ni = r + directions[d][0];
			int nj = c + directions[d][1];
			
			if(nj == C) {
				ans++;
				return true;
			}
			
			if(!(0 <= ni && ni < R)) continue;
			if(map[ni][nj] == 'x') continue;
			
			if(dfs(ni, nj)) {
				return true;
			}
		}

		return false;

	}
}
