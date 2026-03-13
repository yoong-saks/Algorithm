import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

// 출발점 -> 정점 최소 비용
// Dijkstra
public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine()); // 도시 개수 1<=<=1_000
		int M = Integer.parseInt(br.readLine()); // 버스 개수 1<=<=100_000
		
		ArrayList<Node>[] adjList = new ArrayList[N];
		
		int[] dist = new int[N];
		
		for(int i = 0; i < N; ++i) {
			adjList[i] = new ArrayList<>();
			dist[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < M; ++i) {
			st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken()) - 1;
			int end = Integer.parseInt(st.nextToken()) - 1;
			int cost = Integer.parseInt(st.nextToken());
			
			adjList[start].add(new Node(end, cost));
		}
		st = new StringTokenizer(br.readLine());
		
		int u = Integer.parseInt(st.nextToken()) - 1;
		int v = Integer.parseInt(st.nextToken()) - 1;
		
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(u, 0));
		dist[u] = 0;
		
		while(!pq.isEmpty()) {
			Node cur = pq.poll();
			
			if(dist[cur.to] < cur.cost) continue;
			
			if(cur.to == v) {
				break;
			}
			
			for(Node next : adjList[cur.to]) {
				int cost = cur.cost + next.cost;

				if(dist[next.to] <= cost) continue;
				
				dist[next.to] = cost; 
				pq.offer(new Node(next.to, cost));
			}
		}
		
		sb.append(dist[v]);
		System.out.println(sb);
	}
	
	private static class Node implements Comparable<Node> {
		int to;
		int cost;
		
		public Node(int to, int cost) {
			super();
			this.to = to;
			this.cost = cost;
		}
		
		@Override
		public int compareTo(Node o) {
			return Integer.compare(this.cost, o.cost);
		}
		
	}
}
