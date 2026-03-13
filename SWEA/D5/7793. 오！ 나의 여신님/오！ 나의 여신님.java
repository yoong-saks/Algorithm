import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	private static int[][] directions = { {0, 1}, {0, -1}, {-1, 0}, {1, 0} };
	private static char[][] map = new char[50][50];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<IJ> gq = new ArrayDeque<>();
			Queue<IJ> hq = new ArrayDeque<>();
			
			boolean[][] visited = new boolean[N][M];

			
			for(int i = 0; i < N; ++i) {
				StringBuilder tsb = new StringBuilder(br.readLine());
				for(int j = 0; j < M; ++j) {
					map[i][j] = tsb.charAt(j);
					
					if(map[i][j] == 'S') {
						hq.offer(new IJ(i, j));
						visited[i][j] = true;
					}
					if(map[i][j] == '*') {
						gq.offer(new IJ(i, j));
					}
				}
			}
			
//			for(int i = 0; i < N; ++i) {
//				for(int j = 0; j < M; ++j) {
//					System.out.println(map[i][j]);
//				}
//				System.out.println();
//			}
			boolean flag = true;
			boolean escapeSignal = false;
			
			int time = 0;
			while(flag) {
				int gqSize = gq.size();
				int hqSize = hq.size();
				
				time++;
				
				while(gqSize-->0) {
					IJ cur = gq.poll();
					
					for(int d = 0; d < 4; ++d) {
						int ni = cur.i + directions[d][0];
						int nj = cur.j + directions[d][1];
						
						if(!(0 <= ni && ni < N) || !(0 <= nj && nj < M)) continue;
						if(map[ni][nj] == 'D') continue;
						if(map[ni][nj] == 'X') continue;
						if(map[ni][nj] == '*') continue;
						
						map[ni][nj] = '*';
						gq.offer(new IJ(ni, nj));
					}
				}
				
				boolean canGo = false;
				
				while(hqSize-->0) {
					IJ cur = hq.poll();
					
					for(int d = 0; d < 4; ++d) {
						int ni = cur.i + directions[d][0];
						int nj = cur.j + directions[d][1];
						
						if(!(0 <= ni && ni < N) || !(0 <= nj && nj < M)) continue;
						if(map[ni][nj] == 'D') {
							flag = false;
							escapeSignal = true;
							break;
						}
						if(map[ni][nj] == 'X') continue;
						if(map[ni][nj] == '*') continue;
						if(visited[ni][nj]) continue;
						
						canGo = true;
						visited[ni][nj] = true;
						hq.offer(new IJ(ni, nj));
					}
				}
				
				if(canGo == false) {
					flag = false;
				}
			}
			
			sb.append("#").append(t).append(" ");
			
			if(escapeSignal) {
				sb.append(time).append("\n");
			}
			else {
				sb.append("GAME OVER\n");
			}
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
