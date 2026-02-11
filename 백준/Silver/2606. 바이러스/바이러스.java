import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	private static boolean[] visited;
	private static List<ArrayList<Integer>> adjList;
	private static int cnt;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		adjList = new ArrayList<>();
		visited = new boolean[N + 1];
		
		for(int i = 0; i < N + 1; ++i) {
			adjList.add(new ArrayList<>());
		}
		
		for(int i = 0; i < M; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int start = Integer.parseInt(st.nextToken());
			int dest = Integer.parseInt(st.nextToken());
			
			adjList.get(start).add(dest);
			adjList.get(dest).add(start);
		}
		
		visited[1] = true;
		
		dfs(1);
		System.out.println(cnt);
	}
	
	private static void dfs(int idx) {
		for(int i = 0; i < adjList.get(idx).size(); ++i) {
			if(visited[adjList.get(idx).get(i)]) continue;
			visited[adjList.get(idx).get(i)] = true;
			cnt++;
			dfs(adjList.get(idx).get(i));

		}
		
	}
}
