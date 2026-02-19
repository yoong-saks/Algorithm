import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	private static int[][] map = new int[100][100];
	private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(br.readLine());
			int maxDay = 0;
			
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					maxDay = Math.max(maxDay, map[i][j]);
				}
			}
			
			Queue<IJ> q = new ArrayDeque<>();
			int ans = 0;
			
			for(int day = 0; day <= maxDay; ++day) {
				boolean[][] visited = new boolean[N][N];
				int cnt = 0;
				for(int i = 0; i < N; ++i) {
					for(int j = 0; j < N; ++j) {
						if(map[i][j] > day && !visited[i][j]) {
							visited[i][j] = true;
							q.offer(new IJ(i, j));
							
							while(!q.isEmpty()) {
								IJ cur = q.poll();
								
								for(int d = 0; d < 4; ++d) {
									int ni = cur.i + dir[d][0];
									int nj = cur.j + dir[d][1];
									
									if(!(0 <= ni && ni < N) || !(0 <= nj && nj < N)) continue;
									if(visited[ni][nj]) continue;
									if(map[ni][nj] <= day) continue;
									
									visited[ni][nj] = true;
									q.offer(new IJ(ni, nj));
								}
							}
							cnt++;
						}
					}
				}
				
				ans = Math.max(ans, cnt);
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	private static class IJ {
		int i;
		int j;
		
		IJ(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
