import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int g = gcd(N, M);
		
		System.out.println(g + "\n" + (N * M) / g);
		
	}
	
	private static int gcd(int n, int m) {
		return n % m > 0 ? gcd(m, n % m) : m;
	}
}
