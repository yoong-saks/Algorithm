import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int sum = 0;
		int k = 1;
		
		while(sum + k < N) {
			sum += k;
			k++;
		}
		
		int pos = N - sum;
		
		int b = pos;
		int t= k - pos + 1;
		
		System.out.println(t + " " + b);
	}

}
