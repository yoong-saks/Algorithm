import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 4 <= N <= 16
//
public class Solution {
	private static int[][] synergy;
	private static int N;
	private static boolean[] visited;
	private static int minSub;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			N = Integer.parseInt(br.readLine());
			
			visited = new boolean[N];
			synergy = new int[N][N];
			
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {
					synergy[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			minSub = Integer.MAX_VALUE;
			
			cbn(0, 0);
			
			System.out.println("#" + t + " " + minSub);
		}
	}
	
	private static void cbn(int cnt, int start) {
		if(cnt == N / 2) {
			int teamAscore = 0;
			int teamBscore = 0;
//			ArrayList<Integer> arr1 = new ArrayList<>();
//			ArrayList<Integer> arr2 = new ArrayList<>();
//			
//			for(int i = 0; i < N; ++i) {
//				if(visited[i]) arr1.add(i);
//				if(!visited[i]) arr2.add(i);
//			}
//			
//			for(int i = 0; i < N / 2; ++i) {
//				for(int j = i + 1; j < N / 2; ++j) {
//					teamAscore += (synergy[arr1.get(i)][arr1.get(j)] + synergy[arr1.get(j)][arr1.get(i)]);
//					teamBscore += (synergy[arr2.get(i)][arr2.get(j)] + synergy[arr2.get(j)][arr2.get(i)]);
//				}
//			}
			for(int i = 0; i < N; ++i) {
				for(int j = i + 1; j < N; ++j) {
					if(visited[i] ^ visited[j] == true) continue;
					if(visited[i] && visited[j]) {
						teamAscore += (synergy[i][j] + synergy[j][i]);
					} else if(!visited[i] && !visited[j]) {
						teamBscore += (synergy[i][j] + synergy[j][i]);
					}
				}
			}
			
			minSub = Math.min(minSub, Math.abs(teamAscore - teamBscore));
			
			return;
		}
		
		for(int i = start; i < N; ++i) {
			visited[i] = true;
			cbn(cnt + 1, i + 1);
			visited[i] = false;
		}
	}

}
