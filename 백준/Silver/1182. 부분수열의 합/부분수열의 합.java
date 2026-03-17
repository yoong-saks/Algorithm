import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int ans, N, S;
	private static int[] arr;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		arr = new int[N];
		
		for(int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		subset(0, 0, 0);
		
		System.out.println(ans);
	}

	private static void subset(int start, int sum, int cnt) {
		if(start == N) {
			if(cnt > 0) {
				if(sum == S) {
					ans++;
				}
			}

			return;
		}
		
		subset(start + 1, sum + arr[start], cnt + 1);
		subset(start + 1, sum, cnt);
	}
}
