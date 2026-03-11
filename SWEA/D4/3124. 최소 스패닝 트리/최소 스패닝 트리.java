import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			ArrayList<Node>[] adjList = new ArrayList[V];
			
			
			for(int i = 0; i < V; ++i) {
				adjList[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < E; ++i) {
				st = new StringTokenizer(br.readLine());

				int A = Integer.parseInt(st.nextToken()) - 1;
				int B = Integer.parseInt(st.nextToken()) - 1;
				int C = Integer.parseInt(st.nextToken());
				
				adjList[A].add(new Node(B, C));
				adjList[B].add(new Node(A, C));
			}
			
			long ans = 0;
			int cnt = 0;
			
			PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
			
			boolean[] visited = new boolean[V];
			
			pq.add(new Node(0, 0));
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				
				if(visited[cur.end]) continue;
				
				visited[cur.end] = true;
				ans += cur.weight;
				if(++cnt == V) break;
				
				for(Node next : adjList[cur.end]) {
					if(!visited[next.end]) {
						pq.add(next);
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	private static class Node {
		int end;
		int weight;
		public Node(int end, int weight) {
			super();
			this.end = end;
			this.weight = weight;
		}
	}
}
