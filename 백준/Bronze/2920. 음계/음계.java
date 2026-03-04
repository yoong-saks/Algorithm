import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[8];
		for(int i = 0; i < 8; ++i) {
			arr[i] = sc.nextInt();
		}
		
		boolean sort = true;
		boolean reverseSort = true;
		
		for(int i = 0; i < 8; ++i) {
			if(arr[i] != i + 1) sort = false;
			if(arr[7 - i] != i + 1) reverseSort = false;
		}
		
		if(sort) System.out.println("ascending");
		else if(reverseSort) System.out.println("descending");
		else System.out.println("mixed");
	}

}
