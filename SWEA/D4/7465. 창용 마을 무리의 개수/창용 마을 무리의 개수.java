import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	private static int[] uf;

	private static int find(int n) {
		if(n == uf[n]) return n;
		else return uf[n] = find(uf[n]);
	}
	
	private static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1 != p2) uf[p2] = p1;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			uf = new int[N];
			
			for(int i = 0; i < N; ++i) {
				uf[i] = i;
			}
			
			for(int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken()) - 1;
				int end = Integer.parseInt(st.nextToken()) - 1;
				
				if(find(start) != find(end)) {
					union(start, end);
				}
			}
			
			Set<Integer> hs = new HashSet<>();
			
			for(int i = 0; i < N; ++i) {
				hs.add(find(i));
			}
			
			sb.append("#").append(t).append(" ").append(hs.size()).append("\n");
			
		}
		System.out.println(sb);
	}

}
