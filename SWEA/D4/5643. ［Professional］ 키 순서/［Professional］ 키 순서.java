import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Solution {
	private static ArrayList<Integer>[] B_adjList, S_adjList;
	private static boolean[] B_visited, S_visited;
	private static int B_cnt, S_cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(br.readLine()); // 학생들의 수
			int M = Integer.parseInt(br.readLine()); // 두 학생의 키를 비교한 횟수
			
			B_adjList = new ArrayList[N + 1];
			S_adjList = new ArrayList[N + 1];

			
			for(int i = 1; i <= N; ++i) {
				B_adjList[i] = new ArrayList<>();
				S_adjList[i] = new ArrayList<>();
			}
			
			for(int i = 0; i < M; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int start = Integer.parseInt(st.nextToken());
				int dest = Integer.parseInt(st.nextToken());
				
				B_adjList[start].add(dest);
				S_adjList[dest].add(start);
			}
			
			int ans = 0;
			
			for(int i = 1; i <= N; ++i) {
				B_visited = new boolean[N + 1];
				S_visited = new boolean[N + 1];
				B_cnt = S_cnt = 0;
				B_traversal(i);
				S_traversal(i);
				
				if(B_cnt + S_cnt - 1== N) {
					ans++;
				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	private static void B_traversal(int idx) {
		B_cnt++;
		B_visited[idx] = true;
		
		for(int i = 0; i < B_adjList[idx].size(); ++i) {
			if(B_visited[B_adjList[idx].get(i)]) continue;
			B_traversal(B_adjList[idx].get(i));
		}
	}
	
	
	private static void S_traversal(int idx) {
		S_cnt++;
		S_visited[idx] = true;
		
		for(int i = 0; i < S_adjList[idx].size(); ++i) {
			if(S_visited[S_adjList[idx].get(i)]) continue;
			S_traversal(S_adjList[idx].get(i));
		}
	}
}
