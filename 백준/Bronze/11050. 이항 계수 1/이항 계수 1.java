import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int k;
	private static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		n = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		
		// nCk
		combination(0, 0);
		
		System.out.println(ans);
	}
	
	private static void combination(int cnt, int start) {
		if(cnt == k) {
			ans++;
			return;
		}
		
		for(int i = start; i < n; ++i) {
			combination(cnt + 1, i + 1);
		}
	}
}
