import java.util.Scanner;

public class Main
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		
		int a = 1000 - sc.nextInt();
		int[] change = {500, 100, 50, 10, 5, 1};
		int ans = 0;
		int idx = 0;
		
		while(a > 0) {
			ans += a / change[idx];
			a %= change[idx++];
		}
		
		System.out.println(ans);
	}
}