import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; ++i) {
			int level = Integer.parseInt(st.nextToken());
			
			if(level < 250) sb.append(4 + " ");
			else if(level < 275) sb.append(3 + " ");
			else if(level < 300) sb.append(2 + " ");
			else sb.append(1 + " ");
		}
		
		System.out.println(sb);
	}
}
