import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[][] map = new int[100][100];
	
	static class IJ {
		int i;
		int j;
		
		IJ(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int ans = 0;
		
		int[] di = {-1, 0, 1, 0};
		int[] dj = {0, 1, 0, -1};
		
		for(int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		

		for(int rain = 0; rain <= 100; ++rain) {
			int sum = 0;
			boolean[][] visited = new boolean[100][100];
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					if(map[i][j] > rain && !visited[i][j]) {
						Queue<IJ> q = new ArrayDeque<>();
						
						q.offer(new IJ(i, j));
						visited[i][j] = true;
						
						while(!q.isEmpty()) {
							IJ cur = q.poll();
							
							for(int d = 0; d < 4; ++d) {
								int ni = cur.i + di[d];
								int nj = cur.j + dj[d];
								
								if(!(0 <= ni && ni < N) || !(0 <= nj && nj < N)) {
									continue;
								}
								if(map[ni][nj] <= rain) {
									continue;
								}
								if(visited[ni][nj]) {
									continue;
								}
								
								q.offer(new IJ(ni, nj));
								visited[ni][nj] = true;
							}
						}
						
						sum++;
					}
				}
			}
			ans = Math.max(ans, sum);
		}
		
		System.out.println(ans);
	}
}
