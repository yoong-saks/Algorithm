import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	private static int[][] islandCoord;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(br.readLine());
			
			islandCoord = new int[N][2];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; ++i) {
				islandCoord[i][0] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < N; ++i) {
				islandCoord[i][1] = Integer.parseInt(st.nextToken());
			}
			
			double tax = Double.parseDouble(br.readLine());
			
			PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
			boolean[] visited = new boolean[N];
			
			pq.add(new long[] {0, 0});
			long totalDistance = 0;
			int cnt = 0;
			
			while(!pq.isEmpty()) {
				long[] cur = pq.poll();
				
				if(visited[(int)cur[0]]) continue;
				
				
				totalDistance += cur[1];
				visited[(int)cur[0]] = true;
				if(++cnt == N) break;
				
				for(int i = 0; i < N; ++i) {
					long d = calculateDistance(islandCoord[(int)cur[0]], islandCoord[i]);
					
					pq.offer(new long[] {i, d});
				}
			}
			sb.append("#").append(t).append(" ").append(Math.round(tax * (totalDistance))).append("\n");
		}
		System.out.println(sb);
	}
	private static long calculateDistance(int[] n1, int[] n2) {
		long x1 = n1[0];
		long y1 = n1[1];
		long x2 = n2[0];
		long y2 = n2[1];
		
		long d1 = Math.abs(x1 - x2);
		long d2 = Math.abs(y1 - y2);
		
		return ((d1 * d1) + (d2* d2));
	}
}
