import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
	// 2 <= N <= 1조 -> 100만1개 int
	// int 범위 2^32 21억
	// long 범위 2^64 900경
	
	// 그리디 최적화
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int T = sc.nextInt();
		
		for(int t = 1; t <= T; ++t) {
			long N = sc.nextLong();
			
			int cnt = 0;
			// 최대한 N을 rootN으로 만드는 게 이득
			// 2^N으로 만드는걸 하려면 N을 rootN으로 최대한 빨리 만든 후 2^N으로 만드는게 가장 빠름
			// 본인보다 큰 제곱근중 가장 작은 값으로 변경
			while(!(N == 2)) {
				long sqrN = (long)Math.sqrt(N);
				
				if(sqrN * sqrN == N) {
					cnt++;
					N = sqrN;
					
					continue;
				}
				cnt += ((sqrN + 1) * (sqrN + 1)) - N;
				N = (sqrN + 1) * (sqrN + 1);
			}
			
			System.out.println("#" + t + " " + cnt);
		}
	}
}
