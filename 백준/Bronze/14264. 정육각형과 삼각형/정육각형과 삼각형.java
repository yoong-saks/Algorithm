import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		double bottom = ((double)N) / 2;
		double height = ((double)N) * Math.sqrt(3) / 2;
		
		System.out.println(bottom * height);
	}

}
