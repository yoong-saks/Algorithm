import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int[][] map;
	private static int N;
	private static int processorN;
	private static IJ[] processors = new IJ[12];
	private static boolean[] visited = new boolean[12];
	
	private static int ans;
	private static int maxProcessor;
	
	private static final int[] di = {-1, 0, 1, 0};
	private static final int[] dj = {0, 1, 0, -1};
	
	private static class IJ {
		int i;
		int j;
		
		IJ(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			N = Integer.parseInt(br.readLine());
			
			map = new int[N][N];
			maxProcessor = 0;
			processorN = 0;
			
			for(int i = 0; i < N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
					
					if(map[i][j] == 1) { //만약 프로세서라면
						if(i == 0 || j == 0 || i == N - 1 || j == N - 1) { // 가장자리에 있다면
							maxProcessor++; // 어차피 켜져있는 프로세스이므로 maxProcessor 증가
							continue;
						}
						processors[processorN++] = new IJ(i, j);
					}
				}
			}
			
			ans = 2147483647;
			
			dfs(0, 0, maxProcessor, 0);
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	// 부분집합. 내가 현재 프로세서를 dir 방향으로 킨 모든 경우랑, 끈 경우에 따라서 달라짐
	// 2*N : 4096개
	private static void dfs(int cnt, int start, int onProcessor, int sum) {
		if(cnt == processorN) {
			//System.out.println(onProcessor);
			//System.out.println("maxProcessor : " + maxProcessor);
			if(onProcessor > maxProcessor) {
				maxProcessor = onProcessor;
				ans = sum;
			} else if(onProcessor == maxProcessor) {
				ans = Math.min(ans, sum);
			}
			return;
		}
		
		for(int i = start; i < processorN; ++i) {
			for(int d = 0; d < 4; ++d) {
				if(!checkRay(d, processors[i])) continue;
				
				int lineSum = makeRay(d, processors[i]);
				dfs(cnt + 1, i + 1, onProcessor + 1, sum + lineSum);
				removeRay(d, processors[i]);
			}
			dfs(cnt + 1, i + 1, onProcessor, sum);
		}
	}
	
	private static boolean checkRay(int d, IJ processor) {
		int ni = processor.i + di[d];
		int nj = processor.j + dj[d];
		
		while(true) {
			if(!(0 <= ni && ni < N) || !(0 <= nj && nj < N)) { // 벽을만나면 광선 만들수 있음
				return true;
			}
			
			if(map[ni][nj] == 1 || map[ni][nj] == 2) { // 프로세서나 광선을 만나면 만들 수 없음
				return false;
			}
			
			ni += di[d];
			nj += dj[d];
		}
	}
	
	private static int makeRay(int d, IJ processor) {
		int ni = processor.i + di[d];
		int nj = processor.j + dj[d];
		int lineSum = 0;
		
		while(true) {
			if(!(0 <= ni && ni < N) || !(0 <= nj && nj < N)) {
				return lineSum;
			}
			
			map[ni][nj] = 2;
			
			ni += di[d];
			nj += dj[d];
			lineSum++;
		}
	}
	
	private static void removeRay(int d, IJ processor) {
		int ni = processor.i + di[d];
		int nj = processor.j + dj[d];
		
		while(true) {
			if(!(0 <= ni && ni < N) || !(0 <= nj && nj < N)) {
				return;
			}
			
			if(map[ni][nj] == 2) {
				map[ni][nj] = 0;
			}
			
			ni += di[d];
			nj += dj[d];
		}
	}

}
