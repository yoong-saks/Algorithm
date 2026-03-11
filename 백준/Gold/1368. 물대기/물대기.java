import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		// 논의 수 1 ~ 300
		int N = Integer.parseInt(br.readLine());
		
		int[] cost = new int[N];
		
		// i번째 논에 우물을 팔 때 드는 비용
		for(int i = 0; i < N; ++i) {
			cost[i] = Integer.parseInt(br.readLine());
		}
		
		// i번째 논과 j번째 논을 연결하는 데 드는 비용
		int[][] ijCost = new int[N + 1][N + 1];
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(ijCost[i], Integer.MAX_VALUE);
			for(int j = 0; j < N; ++j) {
				ijCost[i][j] = Integer.parseInt(st.nextToken());
			}
			ijCost[i][N] = cost[i];
			ijCost[N][i] = cost[i];
		}
		ijCost[N][N] = Integer.MAX_VALUE;
		
		// 모든 정점을 최소비용으로 연결 후 그 때의 비용과 우물파기 제일 싼 비용을 더하면 됨
		
		boolean[] visited = new boolean[N + 1];
		int[] minEdge = new int[N + 1];
		Arrays.fill(minEdge, Integer.MAX_VALUE);
		
		int totalCost = 0;
		int cnt = 0;
		
		minEdge[0] = 0;
		
		for(int i = 0; i < N + 1; ++i) {
			int min = Integer.MAX_VALUE;
			int minVertex = -1;
			
			for(int j = 0; j < N + 1; ++j) {
				if(!visited[j] && minEdge[j] < min) {
					min = minEdge[j];
					minVertex = j;
				}
			}
			
			if(minVertex == -1) break;
			
			visited[minVertex] = true;
			totalCost += min;
			if(++cnt == N + 1) break;
			
			for(int j = 0; j < N + 1; ++j) {
				if(!visited[j] && ijCost[minVertex][j] < minEdge[j]) {
					minEdge[j] = ijCost[minVertex][j];
				}
			}
		}
		
		System.out.println(totalCost);
	}

}
