import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int N;
	private static int M;
	private static int[] hateBit;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			hateBit = new int[M];
			
			for(int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());

				int num1 = Integer.parseInt(st.nextToken());
				int num2 = Integer.parseInt(st.nextToken());
				
				// xor swap
//				if(num1 > num2) {
//					num1 ^= num2;
//					num2 ^= num1;
//					num1 ^= num2;
//				}
				
				hateBit[i] = 1 << (num1 - 1) | 1 << (num2 - 1);
			}
			
			int ans = 0;

			for(int i = 0; i < (1 << N); ++i) { // 부분집합 경우의 수만큼 반복
				boolean isHate = false;
				for(int j = 0; j < hateBit.length && !isHate; ++j) {
					if((hateBit[j] & i) == hateBit[j]) {
						isHate = true;
						continue;
					}
				}
				if(!isHate) ans++;
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
