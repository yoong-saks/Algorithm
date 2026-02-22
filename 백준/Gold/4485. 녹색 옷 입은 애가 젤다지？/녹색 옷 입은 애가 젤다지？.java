import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map = new int[125][125];
	private static int[][] visited = new int[125][125];
	private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int t = 1;
		
		while(N != 0) {
			PriorityQueue<IJ> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.cost, b.cost));
			
			for(int i = 0; i < N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					visited[i][j] = Integer.MAX_VALUE;
				}
			}
		
			
			pq.offer(new IJ(0, 0, map[0][0]));
			int ans = 0;

			while(!pq.isEmpty()) {
				IJ cur = pq.poll();
				
				if(cur.cost > visited[cur.i][cur.j]) continue;
				if(cur.i == N - 1 && cur.j == N - 1) {
					ans = cur.cost;
					
					break;
				}
				
				for(int d = 0; d < 4; ++d) {
					int ni = cur.i + dir[d][0];
					int nj = cur.j + dir[d][1];
					
					if(!(0 <= ni && ni < N) || !(0 <= nj && nj < N)) continue;
					if(visited[ni][nj] > cur.cost + map[ni][nj]) {
						visited[ni][nj] = cur.cost + map[ni][nj];
						
						pq.offer(new IJ(ni, nj, visited[ni][nj]));
					}
				}
			}
			
			sb.append("Problem ").append(t++).append(": ").append(ans).append("\n");
			
			N = Integer.parseInt(br.readLine());
		}
		
		System.out.println(sb);
		
	}
	
	private static class IJ {
		int i;
		int j;
		int cost;
		
		IJ(int i, int j, int cost) {
			this.i = i;
			this.j = j;
			this.cost = cost;
		}
	}
}
