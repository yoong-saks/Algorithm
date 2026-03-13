import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 상원이의 반에 있는 학생들. 0번은 상원이 (2 <= N <= 500)
			int M = Integer.parseInt(st.nextToken()); // 친구관계수 (1 <= M <= 10_000)
			
			ArrayList<Integer>[] adjList = new ArrayList[N];
			for(int i = 0; i < N; ++i) {
				adjList[i] = new ArrayList<Integer>();
			}
			
			// 상원이의 친한 친구와. 친한 친구의 친구만 선물 줌.
			// 총 몇 명에게 초대장을 주는가?
			for(int i = 0; i < M; ++i) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				
				adjList[a].add(b);
				adjList[b].add(a);
			}
			
			boolean[] visited = new boolean[N];
			Queue<Integer> q = new ArrayDeque<Integer>();
			
			q.offer(0);
			visited[0] = true;
			int ans = 0;
			
			for(int time = 0; time < 2; ++time) {
				int qSize = q.size();
				
				while(qSize-->0) {
					int cur = q.poll();
					
					for(Integer next : adjList[cur]) {
						if(visited[next]) continue;
						
						visited[next] = true;
						q.offer(next);
						ans++;
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
	}

}
