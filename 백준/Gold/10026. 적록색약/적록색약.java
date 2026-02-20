import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	private static StringBuilder sb = new StringBuilder();
	private static char[][] map = new char[100][100];
	private static int N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; ++i) {
			String s = br.readLine();
			for(int j = 0; j < N; ++j) {
				map[i][j] = s.charAt(j);
			}
		}
		
		bfs(false);
		bfs(true);
		
		System.out.println(sb);
	}
	
	private static void bfs(boolean isColorBlind) {
		
		boolean[][] visited = new boolean[N][N];
		
		Queue<IJ> q = new ArrayDeque<>();
		int cnt = 0;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				char start = map[i][j];
				
				if(visited[i][j]) continue;
				
				q.offer(new IJ(i, j));
				visited[i][j] = true;
				
				while(!q.isEmpty()) {
					IJ cur = q.poll();
					
					for(int d = 0; d < 4; ++d) {
						int ni = cur.i + dir[d][0];
						int nj = cur.j + dir[d][1];
						
						if(!(0 <= ni && ni < N) || !(0 <= nj && nj < N)) continue;
						if(visited[ni][nj]) continue;
						
						if(!isColorBlind) {
							if(map[ni][nj] != start) continue;
						} else {
							if(map[ni][nj] == 'B' && (start == 'R' || start == 'G')) continue;
							if((map[ni][nj] == 'R' || map[ni][nj] == 'G') && start == 'B') continue;
						}
						
						q.offer(new IJ(ni, nj));
						visited[ni][nj] = true;
					}
				}
				cnt++;
			}
		}
		sb.append(cnt + " ");
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
