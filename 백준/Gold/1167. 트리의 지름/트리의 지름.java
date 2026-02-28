import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	private static boolean[] visited;
	private static int ans;
	private static int maxNodeIdx;
	
	private static ArrayList<Node>[] tree;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine()); //V = 정점의 개수
	
		tree = new ArrayList[V];
		visited = new boolean[V];
		
		for(int i = 0; i < V; ++i) {
			tree[i] = new ArrayList<>();
			
		}
		
		for(int i = 0; i < V; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int vIdx = Integer.parseInt(st.nextToken());
			while(true) {
				int vNum = Integer.parseInt(st.nextToken());
				if(vNum == -1) break;
				int vDist = Integer.parseInt(st.nextToken());
				
				tree[vIdx - 1].add(new Node(vNum - 1, vDist));
			}

			
		}
		
		dfs(0, tree[0], 0);
		
		Arrays.fill(visited, false);
		dfs(maxNodeIdx, tree[maxNodeIdx], 0);
		
		System.out.println(ans);
	}
	
	private static void dfs(int nodeIdx, ArrayList<Node> node, int distance) {
		if(visited[nodeIdx]) return;
		
		if(ans < distance) {
			ans = distance;
			maxNodeIdx = nodeIdx;
		}
		
		ans = Math.max(ans, distance);
		visited[nodeIdx] = true;
		
		for(int i = 0; i < node.size(); ++i) {
			int vNum = node.get(i).num;
			int vDist = node.get(i).dist;
			
			dfs(vNum, tree[vNum], distance + vDist);
		}
	}
	
	private static class Node {
		int num;
		int dist;
		
		Node(int num, int dist) {
			this.num = num;
			this.dist = dist;
		}
	}
}
