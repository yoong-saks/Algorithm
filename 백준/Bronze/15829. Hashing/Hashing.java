import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		
		BigInteger ans = BigInteger.valueOf(0);
		
		for(int i = 0; i < N; ++i) {
			BigInteger num = BigInteger.valueOf((s.charAt(i) - 'a' + 1));
			BigInteger pow = BigInteger.valueOf(1);
			for(int j = 0; j < i; ++j) {
				pow = pow.multiply(BigInteger.valueOf(31));
			}
			num = num.multiply(pow);
			
			ans = ans.add(num);
		}
		
		ans = ans.mod(BigInteger.valueOf(1234567891));
		
		System.out.println(ans);
	}

}
