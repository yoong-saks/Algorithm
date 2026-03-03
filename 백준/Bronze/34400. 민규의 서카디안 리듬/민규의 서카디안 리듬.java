import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			int tt = Integer.parseInt(br.readLine());
			
			int time = tt % 25;
			
			System.out.println((time < 17 ? "ONLINE" : "OFFLINE"));
		}
	}
}
