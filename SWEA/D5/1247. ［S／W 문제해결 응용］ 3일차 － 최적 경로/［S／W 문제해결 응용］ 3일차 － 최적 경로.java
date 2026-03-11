import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static int N, ans;
	private static IJ start, end;
	private static IJ[] customers = new IJ[10];
	private static boolean[] visited;
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			N = Integer.parseInt(br.readLine());
			
			st = new StringTokenizer(br.readLine());
			start = new IJ(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
			end = new IJ(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			
			for(int i = 0; i < N; ++i) {
				customers[i] = new IJ(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			
			visited = new boolean[N];
			
			ans = Integer.MAX_VALUE;
			// 외판원 순회 (해밀턴 회로를 찾아야 함) 도시수가 최대 10이므로 10! => 3628800 가능
			// np-난해 문제. 도시수 많으면 최적화방법 찾아야함
			findMinDistToGoHome(-1, 0, 0);
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void findMinDistToGoHome(int prevPos, int distance, int cnt) {
		if(distance > ans) return;
		
		if(cnt == N) {
			distance += (Math.abs(end.i - customers[prevPos].i) + Math.abs(end.j - customers[prevPos].j));
			
			ans = Math.min(ans, distance);
			return;
		}
		
		for(int i = 0; i < N; ++i) {
			if(visited[i]) continue;
			visited[i] = true;
			if(prevPos == -1) {
				findMinDistToGoHome(i, distance + Math.abs(start.i - customers[i].i) + Math.abs(start.j - customers[i].j), cnt + 1);
			}
			else {
				findMinDistToGoHome(i, distance + Math.abs(customers[prevPos].i - customers[i].i) + Math.abs(customers[prevPos].j - customers[i].j), cnt + 1);
			}
			visited[i] = false;
		}
	}

	
	private static class IJ {
		int i;
		int j;
		public IJ(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
		
	}
}
