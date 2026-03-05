import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		
		int sum = 0;
		int weight = 0;
		for(int i = 0; i < 13; ++i) {
			char c = s.charAt(i);
			int curWeight = (i % 2 ==0) ? 1 : 3;
			
			if(c == '*') {
				weight = curWeight;
			} else {
				sum += curWeight * (c - '0');
			}
		}
		
		for(int i = 0; i < 10; ++i) {
			if((sum + weight * i) % 10 == 0) {
				System.out.println(i);
			}
		}
	}

}
