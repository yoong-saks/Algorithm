import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb= new StringBuilder();
		
		for(int t = 1; t <= 10; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			
			ArrayList<Integer>[] adjList1 = new ArrayList[V]; // 하향
			ArrayList<Integer>[] adjList2 = new ArrayList[V]; // 상향
			
			for(int i = 0; i < V; ++i) {
				adjList1[i] = new ArrayList<>();
				adjList2[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < E; ++i) {
				int N = Integer.parseInt(st.nextToken()) - 1;
				int M = Integer.parseInt(st.nextToken()) - 1;
				
				adjList1[N].add(M);
				adjList2[M].add(N);
			}
			
			Queue<Integer> q = new ArrayDeque<>();
			boolean[] completed = new boolean[V];
			
			sb.append("#" + t);
			
			for(int i = V - 1; i >= 0; --i) {
				if(adjList2[i].size() == 0) { // 부모가 없는게 시작 노드
					q.offer(i);
					
//					completed[i] = true;
				}
			}
			
			while(!q.isEmpty()) {
				int cur = q.poll();

				if(completed[cur]) continue;
				boolean flag = false;
				
				for(int i = 0; i < adjList2[cur].size(); ++i) {
					if(!completed[adjList2[cur].get(i)]) {
						flag = true;
						break;
					}
				}
				
				if(!flag) { // 내 위가 전부 완료됐다면
					sb.append(" " + (cur + 1));
					completed[cur] = true;
					for(int i = 0; i < adjList1[cur].size(); ++i) {
						if(!completed[adjList1[cur].get(i)]) {
							q.offer(adjList1[cur].get(i));
						}
						
					}
				} else { // 내 위가 전부 완료되지 않았다면
					q.offer(cur); // 다시 넣음
				}
			}
			
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
