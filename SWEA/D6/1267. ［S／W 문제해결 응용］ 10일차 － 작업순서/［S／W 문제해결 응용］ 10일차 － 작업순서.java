import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		// System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		for(int t = 1; t <= 10; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			sb.append("#").append(t);
			
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			ArrayList<Integer>[] graph = new ArrayList[V];
			
			for(int i = 0; i < V; ++i) {
				graph[i] = new ArrayList<>();
			}
			
			int[] inDegree = new int[V];
			
			st = new StringTokenizer(br.readLine());
			for(int i = 0; i < E; ++i) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				
				graph[start - 1].add(end - 1);
				
				inDegree[end - 1]++;
			}
			
			Queue<Integer> q = new ArrayDeque<>();
			
			for(int i = 0; i < V; ++i) {
				if(inDegree[i] == 0) q.offer(i);
			}
			
			while(!q.isEmpty()) {
				int cur = q.poll();
				sb.append(" ").append(cur + 1);
				
				for(int i = 0; i < graph[cur].size(); ++i) {
					if(--inDegree[graph[cur].get(i)] == 0) q.offer(graph[cur].get(i));
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}
}
