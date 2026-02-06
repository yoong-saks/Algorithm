import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	static int[][] ingreInfo;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken()); // 재료의 수
			int maxCal = Integer.parseInt(st.nextToken()); // 최대 칼로리
			
			ingreInfo = new int[N][2];
			
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				
				int score = Integer.parseInt(st.nextToken());
				int calrories = Integer.parseInt(st.nextToken());
				
				ingreInfo[i][0] = score;
				ingreInfo[i][1] = calrories;

			}
			
			int ans = 0;
			
			for(int i = 0; i < (1 << N); ++i) {// 경우의 수만큼 반복
				int calSum = 0;
				int scoSum = 0;
				
				for(int j = 0; j < N; ++j) {
					if((i & (1 << j)) == (1 << j)) { // 현재 부분집합의 조합에 해당하는 버거 index
						if(calSum + ingreInfo[j][1] > maxCal) break;
						scoSum += ingreInfo[j][0];
						calSum += ingreInfo[j][1];
					}
				}
				ans = Math.max(ans, scoSum);
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}

}
