import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		int T = Integer.parseInt(br.readLine());

		for(int t = 1; t <= T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			int[] snacks = new int[N];
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; ++i) {
				snacks[i] = Integer.parseInt(st.nextToken());
			}
			
			// 조합으로 nCr할 경우 On^2 시간 초과
			// 투포인터 정렬로 풀 경우 nlogn + n으로 풀기 가능
			Arrays.sort(snacks);
			
			int s = 0;
			int e = N - 1;
			int sum = 0;
			int ans = -1;
			
			while(s < e) {
				sum = snacks[s] + snacks[e];
				
				//sum이 M이랑 같으면 그냥 조기종료
				if(sum == M) {
					ans = sum;
					break;
				}
				
				if(sum > M) {
					e--;
				} else {
					ans = Math.max(sum, ans);
					s++;
				}
			}
			
			System.out.println("#" + t + " " + ans);
			
			
		}
	}

}
