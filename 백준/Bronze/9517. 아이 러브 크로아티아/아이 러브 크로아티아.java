import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine()) - 1;
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		
		for(int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			sum += Integer.parseInt(st.nextToken());
			char ch = st.nextToken().charAt(0);
			

			if(sum >= 210) break;
			
			if(ch == 'T') {
				K = (K + 1) % 8;
			}
			
		}
		
		System.out.println(K + 1);
	}

}
