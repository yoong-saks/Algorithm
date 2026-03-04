import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		
		int ans = 0;
		
		for(int i = 0; i < N; ++i) {
			ans += ((s.charAt(i) - 'a' + 1) * Math.pow(31, i) % 1234567891);
			
		}
		
		System.out.println(ans);
	}

}
