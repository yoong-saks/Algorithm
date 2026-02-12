import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// N * N * 4 
// 16만번 보고 정답 가릴 수 있음,,
public class Solution {
	private static int N, maxHeight, startIdx, ansIdx;
	private static int[][] map;
	private static boolean[] visited;
	private static IJ[] roomIdx;
	
	private static int[] di = {-1, 0, 1, 0};
	private static int[] dj = {0, 1, 0, -1};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			N = Integer.parseInt(br.readLine());
			
			maxHeight = -1;
			map = new int[N][N];
			visited = new boolean[N * N + 1];
			roomIdx = new IJ[N * N + 1];
			
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					roomIdx[map[i][j]] = new IJ(i, j);
				}
			}
			
			// 무조건 젤 아래방부터 올라감,,
			for(int i = 1; i < N * N + 1; ++i) {
				if(visited[i]) continue;
				
				startIdx = i;
				dfs(roomIdx[i].i, roomIdx[i].j, i, 1);
			}
			
						
			System.out.println("#" + t + " " + ansIdx + " " + maxHeight);
		}
	}
	
	private static void dfs(int r, int c, int idx, int cnt) {
		visited[idx] = true;
		if(maxHeight < cnt) {
			maxHeight = cnt;
			ansIdx = startIdx;
		}
		
		for(int d = 0; d < 4; ++d) {
			int ni = r + di[d];
			int nj = c + dj[d];
			
			//경계값
			if(!(0 <= ni && ni < N) || !(0 <= nj && nj < N)) continue;
			
			//같을 때만
			if(map[r][c] + 1 == map[ni][nj]) {
				dfs(ni, nj, idx + 1, cnt + 1);
			}
		}
	}
	
	private static class IJ {
		int i; // 제일 작은 친구 인덱스 정보
		int j; 
		
		IJ(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
