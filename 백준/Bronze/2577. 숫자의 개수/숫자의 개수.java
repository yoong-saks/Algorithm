import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int[] arr = new int[10];
		
		int num = A * B * C;
		
		while(num != 0) {
			arr[num % 10]++;
			
			num /= 10;
		}
		
		for(int i = 0; i < 10; ++i) {
			System.out.println(arr[i]);
		}
	}

}
