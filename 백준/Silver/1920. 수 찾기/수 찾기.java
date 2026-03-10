import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());

		Set<Integer> hs = new HashSet<>();
		
		for(int i = 0; i < N; ++i) {
			hs.add(Integer.parseInt(st.nextToken()));
		}
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; ++i) {
			String s2 = st.nextToken();
			sb.append(hs.contains(Integer.parseInt(s2)) ? "1\n" : "0\n");
		}
		
		System.out.println(sb);
	}
}
