import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			int profit = 0;
			boolean flag = true;
			int size = 1;
			
			int N = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < N; ++i) {
				String s = br.readLine();
				for(int j = 0; j < N; ++j) {
					if((N - size) / 2 <= j && j < N -((N - size) / 2)) {
						profit += s.charAt(j) - '0';
					}
				}
				size += flag ? 2 : -2;
				if(size > N) {
					flag = false;
					size -= 4;
				}
			}
			
			System.out.println("#" + t + " " + profit);
		}
	}
}
