import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map = new int[50][50];
	private static int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	private static int[] airPos = new int[2];
	private static int R, C, T;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());

		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < R; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < C; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == -1) {
					airPos[0] = i;
					airPos[1] = j;
				}
			}
		}
		
		int[][] diffMap = new int[R][C];
		
		for(int time = 0; time < T; ++time) {
			for(int i = 0; i < R; ++i) {
				Arrays.fill(diffMap[i], 0);
			}
			
			for(int i = 0; i < R; ++i) {
				for(int j = 0; j < C; ++j) {
					if(map[i][j] > 0) {
						diffusion(i, j, diffMap);
					}
				}
			}
			
			for(int i = 0; i < R; ++i) {
				for(int j = 0; j < C; ++j) {
					map[i][j] += diffMap[i][j];
				}
			}
			
			activateAirfilter();
		}
		int ans = 0;
		for(int i = 0; i < R; ++i) {
			for(int j = 0; j < C; ++j) {
				if(map[i][j] > 0) ans += map[i][j];
			}
		}
		
		System.out.println(ans);
	}
	
	private static void activateAirfilter() {
		int bottomPosR = airPos[0];
		int topPosR = airPos[0] - 1;
		
		//먼저 위쪽 회전부터
		for(int i = topPosR - 1; i >= 1; --i) map[i][0] = map[i - 1][0];
		for(int i = 0; i < C - 1; ++i) map[0][i] = map[0][i + 1];
		for(int i = 0; i <= topPosR - 1; ++i) map[i][C - 1] = map[i + 1][C - 1];
		for(int i = C - 1; i >= 1; --i) map[topPosR][i] = map[topPosR][i - 1];
		
		//아래쪽 회전
		for(int i = bottomPosR + 1; i < R - 1; ++i) map[i][0] = map[i + 1][0];
		for(int i = 0; i < C - 1; ++i) map[R - 1][i] = map[R - 1][i + 1];
		for(int i = R - 1; i > bottomPosR; --i) map[i][C - 1] = map[i - 1][C - 1];
		for(int i = C - 1; i >= 1; --i) map[bottomPosR][i] = map[bottomPosR][i - 1];
		
		map[topPosR][1] = 0;
		map[bottomPosR][1] = 0;
	}
	
	private static void diffusion(int r, int c, int[][] diffMap) {
		int cnt = 0;
		for(int d = 0; d < 4; ++d) {
			int ni = r + directions[d][0];
			int nj = c + directions[d][1];
			
			if(!(0 <= ni && ni < R) || !(0 <= nj && nj < C)) continue;
			if(map[ni][nj] == -1) continue;
			
			diffMap[ni][nj] += map[r][c] / 5;
			cnt++;
		}
		map[r][c] = map[r][c] - ((map[r][c] / 5) * cnt);
	}
}
