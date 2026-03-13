import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map = new int[200][200];
	private static boolean[][][] visited;
	
	private static int[][] dir1 = { {-2, 1}, {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1} };
	private static int[][] dir2 = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine()); // 원숭이가 말 능력을 쓸수 있는 수
		
		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < H; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < W; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		visited = new boolean[K + 1][H][W];
		
		Queue<IJK> q = new ArrayDeque<>();
		//PriorityQueue<IJK> q = new PriorityQueue<>((a, b) -> Integer.compare(a.time, b.time));
		
		q.offer(new IJK(0, 0, K, 0));
		visited[0][0][0] = true;
		
		int ans = -1;
		boolean find = false;
		while(!q.isEmpty()) {
			IJK cur = q.poll();
			if(cur.ability > 0) {
				for(int d = 0; d < 8; ++d) {
					int ni = cur.i + dir1[d][0];
					int nj = cur.j + dir1[d][1];
					int nk = K - cur.ability + 1;
					if(ni == H - 1 && nj == W - 1) {
						ans = cur.time + 1;
						q.clear();
						find = true;
						break;
					}
					
					if(!(0 <= ni && ni < H) || !(0 <= nj && nj < W)) continue;
					if(visited[nk][ni][nj]) continue;
					if(map[ni][nj] == 1) continue;
					
					visited[nk][ni][nj] = true;
					q.offer(new IJK(ni, nj, cur.ability - 1, cur.time + 1));
				}
			}
			if(find) break;
			for(int d = 0; d < 4; ++d) {
				int ni = cur.i + dir2[d][0];
				int nj = cur.j + dir2[d][1];
				int nk = K - cur.ability;
				
				if(ni == H - 1 && nj == W - 1) {
					ans = cur.time + 1;
					q.clear();
					break;
				}
				
				if(!(0 <= ni && ni < H) || !(0 <= nj && nj < W)) continue;
				if(visited[nk][ni][nj]) continue;
				if(map[ni][nj] == 1) continue;
				
				visited[nk][ni][nj] = true;
				q.offer(new IJK(ni, nj, cur.ability, cur.time + 1));
			}
		}
		if(W == 1 && H == 1) ans = 0;
		System.out.println(ans);
	}
	
	private static class IJK {
		int i;
		int j;
		int ability;
		int time;
		public IJK(int i, int j, int ability, int time) {
			super();
			this.i = i;
			this.j = j;
			this.ability = ability;
			this.time = time;
		}

		
	}
}
