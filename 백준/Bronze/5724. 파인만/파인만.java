import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	private static int[] dp = new int[101];
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		for(int i = 1; i < 101; ++i) {
			dp[i] = dp[i - 1] + i * i;
		}
		
		while(true) {
			int N = Integer.parseInt(br.readLine());
			
			if(N == 0) break;
			
			System.out.println(dp[N]);
		}
	}

}
