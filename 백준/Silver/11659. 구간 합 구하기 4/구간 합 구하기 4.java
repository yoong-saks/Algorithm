import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		int[] ans = new int[M];
		int sum = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; ++i) {
			sum += Integer.parseInt(st.nextToken());
			arr[i + 1] = sum;
		}
		
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int I = Integer.parseInt(st.nextToken());
			int J = Integer.parseInt(st.nextToken());
			
			ans[i] = arr[J] - arr[I - 1];
		}
		
		for(Integer i : ans) {
			System.out.println(i);
		}
	}
}
