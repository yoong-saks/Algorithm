import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int[] op = new int[4];
	private static int[] oper;
	private static int N;
	private static int minAns;
	private static int maxAns;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			N = Integer.parseInt(br.readLine());
			oper = new int[N];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < 4; ++i) {
				op[i] = Integer.parseInt(st.nextToken());
			}
			
			st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < N; ++i) {
				oper[i] = Integer.parseInt(st.nextToken());
			}
			
			minAns = 2147483647;
			maxAns = -2147483648;
			
			dfs(0, oper[0]);
			
			System.out.println("#" + t + " " + (maxAns - minAns));
		}
	}
	
	//N - 1개중 N - 1개를 뽑는 순열의 수 ((N - 1)!)
	//N = 12이므로 11개의 순열 수 4천만. 그냥 순열로 해도 시간초과는 안나긴 함
	//연산자가 같으면 뒤집어도 같음.
	private static void dfs(int cnt, int result) {
		if(cnt == (N - 1)) {
			minAns = Math.min(minAns, result);
			maxAns = Math.max(maxAns, result);
			return;
		}
		
		for(int i = 0; i < 4; ++i) {
			if(op[i] <= 0) continue;
			
			op[i]--;
			dfs(cnt + 1, calculator(result, oper[cnt + 1], i));
			op[i]++;
		}
	}
	
	private static int calculator(int oper1, int oper2, int op) {
		if(op == 0) return oper1 + oper2;
		if(op == 1) return oper1 - oper2;
		if(op == 2) return oper1 * oper2;
		return oper1 / oper2;
	}
}
