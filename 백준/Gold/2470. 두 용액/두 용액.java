import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < N; ++i) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int s = 0;
		int e = N - 1;
		int ans1 = 0;
		int ans2 = 0;
		int min = 2_000_000_000;
		
		while(s < e) {
			int sum = arr[s] + arr[e];
			
			if(min > Math.abs(sum)) {
				min = Math.abs(sum);
				ans1 = arr[s];
				ans2 = arr[e];
			}
			
			if(sum == 0) {
				break;
			}
			
			if(sum > 0) {
				e--;
			} else {
				s++;
			}
		}
		
		System.out.println(ans1 + " " + ans2);
		
	}
}
