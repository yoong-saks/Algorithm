import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] directions = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
		
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 0; t < T; ++t) {
			st = new StringTokenizer(br.readLine());
			
			int M = Integer.parseInt(st.nextToken());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[][] map = new int[N][M];
			
			for(int i = 0; i < K; ++i) {
				st = new StringTokenizer(br.readLine());
				
				int c = Integer.parseInt(st.nextToken());
				int r = Integer.parseInt(st.nextToken());
				
				map[r][c] = 1;
			}
			
			
			Queue<IJ> q = new ArrayDeque<>();
			int cnt = 0;
			
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < M; ++j) {
					if(map[i][j] == 1) {
						q.offer(new IJ(i, j));
						map[i][j] = 0;
						
						while(!q.isEmpty()) {
							IJ cur = q.poll();
							
							for(int d = 0; d < 4; ++d) {
								int ni = cur.i + directions[d][0];
								int nj = cur.j + directions[d][1];
								
								if(!(0 <= ni && ni < N) || !(0 <= nj && nj < M)) continue;
								if(map[ni][nj] == 0) continue;
								
								q.offer(new IJ(ni, nj));
								map[ni][nj] = 0;
							}
						}
						cnt++;
					}
				}
			}
			sb.append(cnt).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static class IJ {
		int i;
		int j;
		public IJ(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
	}
}
