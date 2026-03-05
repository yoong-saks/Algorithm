import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
	private static int[] nodes;
	
	private static int find(int n) {
		if(n == nodes[n]) {
			return n;
		}
		else {
			return nodes[n] = find(nodes[n]);
		}
		
	}
	
	private static void union(int n1, int n2) {
		int pN1 = find(n1);
		int pN2 = find(n2);
		
		if(pN1 != pN2) nodes[pN1] = pN2;
	}

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(st.nextToken());
		
		for(int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] islands = new int[N][2];
			nodes = new int[N];
			
			for(int i = 0; i < N; ++i) {
				nodes[i] = i;
			}
			for(int i = 0; i < 2; ++i) {
				st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < N; ++j) {
					int num = Integer.parseInt(st.nextToken());
					
					islands[j][i] = num;
				}
			}
			
			double E = Double.parseDouble(br.readLine());
			
			PriorityQueue<DSE> distances = new PriorityQueue<>((a, b) -> Long.compare(a.distance, b.distance));
			for(int i = 0; i < N - 1; ++i) {
				for(int j = i + 1; j < N; ++j) {
					long a = Math.abs(islands[i][0] - islands[j][0]);
					long b = Math.abs(islands[i][1] - islands[j][1]);
					long distance = a * a + b * b;
					distances.add(new DSE(distance, i, j));
				}
			}
			
			long ans = 0;
			
			for(int i = 0; i < N - 1; ++i) {
				DSE cur = distances.poll();
				if(find(cur.start) == find(cur.end)) {
					i--;
					continue;
				}
				
				union(cur.start, cur.end);
				ans += cur.distance;
			}
			
			System.out.println("#" + t + " " + Math.round(E * ans));
		}
	}
	
	private static class DSE {
		long distance;
		int start;
		int end;
		
		DSE(long distance, int start, int end) {
			this.distance = distance;
			this.start = start;
			this.end = end;
		}
	}
	
}
