import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		// ========================================= //

		int N = Integer.parseInt(br.readLine());
		int cnt = 0;

		for(int i = 1; i <= N * 2; ++i) {
			if(i % 2 != 0) { // 홀수면,
				for(int j = 0; j < N - cnt; ++j) {
					sb.append("* ");
				}
				sb.append("\n");
			} else {
				for(int j = 0; j <= cnt; ++j) {
					sb.append("* ");
				}
				sb.append("\n");
				cnt++;
			}

			
		}
		// ========================================= //
		
		System.out.println(sb);
    }
}