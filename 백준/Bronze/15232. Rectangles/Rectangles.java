import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		
		int R = sc.nextInt();
		int C = sc.nextInt();
		
		for(int i = 0; i < R; ++i) {
			for(int j = 0; j < C; ++j) {
				sb.append('*');
			}
			sb.append('\n');
		}
		
		System.out.println(sb);
	}

}
