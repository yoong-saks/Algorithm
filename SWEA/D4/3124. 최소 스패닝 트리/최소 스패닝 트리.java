import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	private static int[] ufm = new int[100_100];
	
	private static int find(int n) {
		if(ufm[n] == n) return n;
		else return ufm[n] = find(ufm[n]);
	}
	
	private static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);
		
		if(p1 != p2) ufm[p1] = p2;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < V; ++i) {
				ufm[i] = i;
			}
			
			PriorityQueue<SEW> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
			
			for(int i = 0; i < E; ++i) {
				st = new StringTokenizer(br.readLine());

				int s = Integer.parseInt(st.nextToken()) - 1;
				int e = Integer.parseInt(st.nextToken()) - 1;
				int w = Integer.parseInt(st.nextToken());
				
				pq.offer(new SEW(s, e, w));
			}
			
			int connected = 0;
			long ans = 0;
			while(true) {
				if(connected == V - 1) break;
				SEW cur = pq.poll();
				
				if(find(cur.start) == find(cur.end)) continue;
				
				union(cur.start, cur.end);
				connected++;
				ans += (long)cur.weight;
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	private static class SEW {
		int start;
		int end;
		int weight;
		public SEW(int start, int end, int weight) {
			super();
			this.start = start;
			this.end = end;
			this.weight = weight;
		}
		
	}
}
