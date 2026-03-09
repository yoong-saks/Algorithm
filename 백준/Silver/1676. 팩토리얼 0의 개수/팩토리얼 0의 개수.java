import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
	private static BigInteger[] memo = new BigInteger[501];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < 501; ++i) {
			makeFactorialNums(i);
		}

		int offset = -1;
		
		for(int i = memo[N].toString().length() - 1; i >= 0; --i) {
			int n = memo[N].toString().charAt(i) - '0';
			
			if(n == 0) offset++;
			else break;
		}
		
		if(offset == -1) System.out.println(0);
		else System.out.println(offset + 1);
	}
	
	private static void makeFactorialNums(int n) {
		if(n == 0) {
			memo[0] = BigInteger.valueOf(1);
			return;
		}
		
		memo[n] = memo[n - 1].multiply(BigInteger.valueOf(n));
	}

}
