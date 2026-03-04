import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int ans = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int arrivalTime = Integer.parseInt(st.nextToken());
			int breadTime = Integer.parseInt(st.nextToken());
			
			if(arrivalTime <= breadTime) ans = Math.min(breadTime, ans);
			
			
		}
		if(ans == Integer.MAX_VALUE) ans = -1;
		
		System.out.println(ans);
	}

}
