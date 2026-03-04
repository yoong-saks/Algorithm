import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < N; ++i) {
			int a = Integer.parseInt(br.readLine());
			System.out.println(((a&(-a)) == a) ? 1 : 0);
		}
	
	}

}
