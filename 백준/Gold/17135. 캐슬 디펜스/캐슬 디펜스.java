import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static int N, M, D;
	
	private static int[][] map = new int[16][16];
	private static int[][] copyMap;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int[] arrows = new int[3];
		int ans = 0;
		
		for(int bm = 0; bm < 1 << M; ++bm) {
			if(Integer.bitCount(bm) == 3) {
				
				int kill = 0;
				int cnt = 0;
				
				for(int i = 0; i < M; ++i) {
					if((bm & (1 << i)) != 0) {
						arrows[cnt++] = i;
					}
				}
				
				copyMap = new int[N][M];
				for(int i = 0; i < N; ++i) {
					System.arraycopy(map[i], 0, copyMap[i], 0, M);
				}
				
				for(int i = 0; i < N; ++i) { //모든 적이 이동할때까지 반복
					
					Set<Integer> hs = new HashSet<>();
					
					for(int j = 0; j < 3; ++j) { //모든 궁수가
						int result = inRange(arrows[j]);
						if(result == -1) continue;
						
						hs.add(result);
					}
					
					for(Integer j : hs) {
						int row = j >> 16;
						int col = j & 0x0000FFFF;
						
						copyMap[row][col] = 0;
						kill++;
					}
					
					move();
				}
				ans = Math.max(kill, ans);
			}
		}
		
		System.out.println(ans);
	}
	
	private static void move() {
		for(int i = N - 1; i > 0; --i) {
			for(int j = 0; j < M; ++j) {
				copyMap[i][j] = copyMap[i - 1][j];
			}
		}
		
		for(int j = 0; j < M; ++j) {
			copyMap[0][j] = 0;
		}
	}
	
	private static int inRange(int c) {
		// 우선순위 1 : 가장 가까운 곳
		// 우선순위 2 : 가장 왼쪽에 있는 놈
		int ci = N;
		int cj = c;
		
		int minDist = Integer.MAX_VALUE;
		int ti = -1;
		int tj = -1;
		
		for(int j = 0; j < M; ++j) { // 왼쪽부터 탐색
			for(int i = N - 1; i >= 0; --i) {
				if(copyMap[i][j] == 1) {
					int dist = Math.abs(ci - i) + Math.abs(cj - j);
				
					if(dist <= D && dist < minDist) {
						minDist = dist;
						ti = i;
						tj = j;
					}
				}
			}
		}
		
		if(minDist == Integer.MAX_VALUE) return -1;
		return (ti << 16) | (tj & 0xFFFF);
	}

}
