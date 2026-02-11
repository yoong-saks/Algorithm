import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class Solution {
	
	public static void main(String[] args) throws Exception {
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StreamTokenizer st = new StreamTokenizer(System.in);
		st.nextToken();
		int T = (int)st.nval;
		
		for(int t = 1; t <= T; ++t) {
			st.nextToken();
			int N = (int)st.nval;
			
			
			st.nextToken();
			int prev = (int)st.nval;
			boolean flag = false;
			
			List<Integer> list = new ArrayList<>();
			
			for(int i = 1; i < N; ++i) {
				st.nextToken();
				int cur = (int)st.nval;
				
				if(prev < cur && !flag) {
					flag = true;
					list.add(i - 1);
				}
				if(prev > cur) {
					if(flag) {
						list.add(i - 1);
						flag = false;
					}
					if(i == N - 1) list.add(i);

				}
				prev = cur;
			}
			
			int ans = 0;
			
			for(int i = 1; i < list.size(); i += 2) {
				ans += ((list.get(i) - list.get(i - 1)) * (list.get(i + 1) - list.get(i)));
				
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
}
