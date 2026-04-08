import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int t = 1; t <= T; ++t) {
			int[] dp = new int[1001];
			
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				
				int V = Integer.parseInt(st.nextToken());
				int C = Integer.parseInt(st.nextToken());
				
				for(int w = K; w >= 1; --w) {
					if(w - V >= 0) {
						dp[w] = Math.max(dp[w], dp[w - V] + C);
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(dp[K]).append("\n");
		}
		
		System.out.println(sb);
	}

}
