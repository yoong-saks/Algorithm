import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int N;
	private static int[] weight = new int[10];
	private static boolean[] visited = new boolean[10];
	private static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			N = Integer.parseInt(br.readLine());
			
			st= new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N; ++i) {
				weight[i] = Integer.parseInt(st.nextToken());
			}
			
			ans = 0;
			
			btk(0,0,0);
			
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void btk(int cnt, int leftSum, int rightSum) {
		if(rightSum > leftSum) return;
		if(cnt == N) {
			ans++;
			return;
		}
		
		for(int i = 0; i < N; ++i) {
			if(visited[i]) continue;
			visited[i] = true;
			btk(cnt + 1, leftSum + weight[i], rightSum);
			btk(cnt + 1, leftSum, rightSum + weight[i]);
			visited[i] = false;
		}
	}

}
