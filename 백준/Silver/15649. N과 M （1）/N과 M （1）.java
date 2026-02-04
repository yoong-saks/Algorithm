import java.util.Scanner;

public class Main {
	static int N;
	static int M;
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		M = sc.nextInt();
		
		visited = new boolean[N + 1];
		
		dfs(0, new int[M]);
	}
	
	public static void dfs(int level, int[] arr) {
		if(level == M) {
			for(Integer i : arr) {
				System.out.print(i + " ");
			}
			System.out.println();
			
			return;
		}
		
		for(int i = 1; i <= N; ++i) {
			if(!visited[i]) {
				visited[i] = true;
				arr[level] = i;
				
				dfs(level + 1, arr);
				visited[i] = false;
			}
		}
	}
}
