import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		int[][] map = new int[N][M];
		
		Queue<int[]> q = new ArrayDeque<>();
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					q.offer(new int[] {i, j});
				}
			}
		}
		int ans = 0;
		
		while(!q.isEmpty()) {
			int[] cur = q.poll();
			ans = map[cur[0]][cur[1]];
			
			for(int d = 0; d < 4; ++d) {
				int ni = cur[0] + dir[d][0];
				int nj = cur[1] + dir[d][1];
				
				if(!(0 <= ni && ni < N) || !(0 <= nj && nj < M)) continue;
				if(map[ni][nj] != 0) continue;

				map[ni][nj] = map[cur[0]][cur[1]] + 1;
				q.offer(new int[] {ni, nj});
			}
		}
		
		for(int i = 0;  i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(map[i][j] == 0) ans = 0;
			}
		}
		
		System.out.println(ans - 1);
	}
}
