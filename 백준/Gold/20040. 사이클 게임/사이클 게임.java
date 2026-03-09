import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	private static int[] ufm = new int[500_000];
	
	private static int find(int num) {
		if(ufm[num] == num) return num;
		else return ufm[num] = find(ufm[num]);
	}
	
	private static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1 != p2) ufm[p2] = p1;
	}
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken()); // 점의 개수 3 ~ 500_000
		int M = Integer.parseInt(st.nextToken()); // 턴의 수 3 <= <= 1,000,000
		
		for(int i = 0; i < N; ++i) {
			ufm[i] = i;
		}
		
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(find(a) != find(b)) {
				union(a, b);
			} else {
				System.out.println(i + 1);
				return;
			}
			
		}
		System.out.println(0);
	}

}
