import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; ++i) {
			String s = br.readLine();
			int ans = 0;
			int cnt = 1;
			for(int j = 0; j < s.length(); ++j) {
				if(s.charAt(j) == 'O') ans += cnt++;
				else cnt = 1;
			}
			
			System.out.println(ans);
		}
	}

}
