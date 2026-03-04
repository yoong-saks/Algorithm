import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[6];
		
		for(int i = 0; i < 6; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < 6; ++i) {
			if(arr[i] == 0) continue;
			ans += ((arr[i] - 1) / T + 1);
		}
		
		System.out.println(ans);
		System.out.println(N / P + " " + N % P );
	}
}
