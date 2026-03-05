import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int[][] memo = new int[15][15];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			int k = Integer.parseInt(br.readLine());
			int n = Integer.parseInt(br.readLine());
			
			int ans = find(k, n);
			
			System.out.println(ans);
		}
	}
	
	private static int find(int k, int n) {
		if(k < 0 || n < 0) return 0;
		if(memo[k][n] > 0) return memo[k][n];
		
		if(k == 0) {
			for(int i = 0; i < 15; ++i) {
				memo[0][i] = i;
			}
		}
		
		return memo[k][n] = find(k, n - 1) + find(k - 1, n);
	}

}
