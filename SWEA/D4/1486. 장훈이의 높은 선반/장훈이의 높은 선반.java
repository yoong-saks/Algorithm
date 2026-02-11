import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	private static int[] height;
	private static boolean[] visited;
	private static int N, B, minHeight;
	// N = 20 -> 2^20 부분집합으로 풀어도됨
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken()); // 점원들의 수
			B = Integer.parseInt(st.nextToken()); // 선반의 높이
			height = new int[N];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; ++i) {
				int S = Integer.parseInt(st.nextToken()); //점원의 키
				height[i] = S;
			}
			
			minHeight = 20000000;
			
			btk(0, 0);
			
			System.out.println("#" + t + " " + (minHeight - B));
		}
	}
	
	private static void btk(int idx, int sum) {
		if(sum >= minHeight) return;
		
		if(sum >= B) {
			minHeight = Math.min(minHeight, sum);
			
			return;
		}
		
		if(idx == N) return;
		
		btk(idx + 1, sum + height[idx]);
		btk(idx + 1, sum);
	}

}
