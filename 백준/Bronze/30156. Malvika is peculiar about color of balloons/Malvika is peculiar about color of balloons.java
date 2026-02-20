import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; ++i) {
			String s = br.readLine();
			int acnt = 0;
			int bcnt = 0;
			for(int j = 0; j < s.length(); ++j) {
				if(s.charAt(j) == 'b') bcnt++;
				if(s.charAt(j) == 'a') acnt++;
			}
			
			sb.append(Math.min(acnt, bcnt) + "\n");
		}
		
		System.out.println(sb);
	}
}
