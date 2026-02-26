import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Solution {
	private static int N;
	private static int M;
	private static int K;
	private static ArrayDeque<Micron>[][] map;
	private static Micron[] arr;
	
	private static int[][] direction = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
	
	// 미생물 격리 빡구현
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); // 맵의 크기
			M = Integer.parseInt(st.nextToken()); // 격리 시간
			K = Integer.parseInt(st.nextToken()); // 미생물 수
			
			map = new ArrayDeque[N][N];
			arr= new Micron[K];
			
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					map[i][j] = new ArrayDeque<Micron>();
				}
			}
			
			for(int i = 0; i < K; ++i) {
				st = new StringTokenizer(br.readLine());
				
				int posI = Integer.parseInt(st.nextToken());
				int posJ = Integer.parseInt(st.nextToken());
				int cnt = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				
				map[posI][posJ].add(new Micron(posI, posJ, cnt, dir));
			}
			
			for(int i = 0; i < M; ++i) {
				move();
			}
			
			int ans = 0;
			
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					if(map[i][j].size() != 0) {
						ans += map[i][j].peek().cnt;
					}
				}
			}
			
			
			System.out.println("#" + t + " " + ans);
		}
		
	}
	private static void move() {
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				if(map[i][j].size() != 0) {
					if(map[i][j].peekFirst().moved) continue;
					
					Micron cur = map[i][j].pollFirst();
					
					
					
					int ni = cur.i + direction[cur.dir - 1][0];
					int nj = cur.j + direction[cur.dir - 1][1];
					

					map[ni][nj].add(cur);
					cur.i = ni;
					cur.j = nj;
					cur.moved = true;
					
					if(ni == 0) { cur.dir = 2; cur.cnt /= 2; }
					if(ni == N - 1) { cur.dir = 1; cur.cnt /= 2; }
					if(nj == 0) { cur.dir = 4; cur.cnt /= 2; }
					if(nj == N - 1) { cur.dir = 3; cur.cnt /= 2; }
				}
			}
		}
		
		combineMicron();
	}
	
	private static void combineMicron() {
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				if(map[i][j].size() != 0) {
					int maxMicronDir = -1;
					int maxMicronCnt = -1;
					int sum = 0;
					
					while(!map[i][j].isEmpty()) {
						Micron m = map[i][j].pollFirst();
						
						sum += m.cnt;
						if(maxMicronCnt < m.cnt) {
							maxMicronCnt = m.cnt;
							maxMicronDir = m.dir;
						}
					}
					
					map[i][j].add(new Micron(i, j, sum, maxMicronDir));
				}
			}
		}
	}
	
	private static class Micron {
		int i;
		int j;
		int cnt;
		int dir;
		boolean moved = false;
		
		Micron(int i, int j, int cnt, int dir) {
			this.i = i;
			this.j = j;
			this.cnt = cnt;
			this.dir = dir;
		}
	}
}
