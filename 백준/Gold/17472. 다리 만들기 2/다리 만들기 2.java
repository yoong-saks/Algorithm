import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	
	private static int[] ufm = new int[100];
	
	private static int[][] map = new int[10][10];
	private static int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	
	private static int find(int n) {
		if(ufm[n] == n) return n;
		else return ufm[n] = find(ufm[n]);
	}
	
	private static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1 != p2) ufm[p1] = p2;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		// 섬 라벨링
		Queue<IJ> q = new ArrayDeque<>();
		int islandNum = 0;
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(map[i][j] == 1) {
					islandNum++;
					bfsLabeling(i, j, q, islandNum);
				}
			}
		}
//		
//		for(int i = 0; i < N; ++i) {
//			for(int j = 0; j < M; ++j) {
//				System.out.print(map[i][j] + " ");
//			}
//			System.out.println();
//		}
//		
		PriorityQueue<IJ> pq = new PriorityQueue<>((a, b) -> a.w - b.w);
		//각 섬에서 다른 섬까지 가는 모든 간선정보와 다리 길이 측정 (다리길이가 1은 안됨)
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < M; ++j) {
				if(map[i][j] != 0) {
					for(int d = 0; d < 4; ++d) {
						pq.addAll(IslandSearch(i, j, d, map[i][j]));
					}
					
				}
			}
		}
		
		if(pq.size() == 0) {
			System.out.println(-1);
			return;
		}
		
		for(int i = 1; i <= islandNum; ++i) {
			ufm[i] = i;
		}
		
		int connected = 0;
		int ans = 0;
		while(!pq.isEmpty()) {
			if(connected == islandNum - 1) break;
			
			IJ cur = pq.poll();
			
			if(find(cur.i * -1) != find(cur.j * -1)) {
				union(cur.i * -1, cur.j * -1);
				ans += cur.w;
				connected++;
			}
		}
		if(connected != islandNum - 1) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(ans);
	}
	
	private static ArrayList<IJ> IslandSearch(int i, int j, int d, int startIsland) {

		ArrayList<IJ> arr = new ArrayList<>();
		int ci = i;
		int cj = j;
		
		int distance = 0;
		while(true) {
			int ni = ci + directions[d][0];
			int nj = cj + directions[d][1];
			if(!(0 <= ni && ni < N) || !(0 <= nj && nj < M)) break;
			
			if(map[ni][nj] == startIsland) break;
			if(map[ni][nj] == 0) {
				ci = ni;
				cj = nj;
				distance++;
				continue;
			}
			
			if(map[ni][nj] != startIsland) {
				if(distance > 1) {
					arr.add(new IJ(startIsland, map[ni][nj], distance));
					break;
				}
				if(distance <= 1) break;
			}
		}
		
		
		return arr;
	}
	private static void bfsLabeling(int i, int j, Queue<IJ> q, int islandNum) {
		q.offer(new IJ(i, j));
		map[i][j] = -1 * islandNum;
		
		while(!q.isEmpty()) {
			IJ cur = q.poll();
			
			for(int d = 0; d < 4; ++d) {
				int ni = cur.i + directions[d][0];
				int nj = cur.j + directions[d][1];
				
				if(!(0 <= ni && ni < N) || !(0 <= nj && nj < M)) continue;
				if(map[ni][nj] != 1) continue;
				
				map[ni][nj] = -1 * islandNum;
				q.offer(new IJ(ni, nj));
			}
		}
	}
	
	private static class IJ {
		int i;
		int j;
		int w;
		public IJ(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		public IJ(int i, int j, int w) {
			this(i, j);
			this.w = w;
		}
	}
}
