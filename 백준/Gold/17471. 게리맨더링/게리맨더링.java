import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	private static int[] population = new int[11];
	private static int N;
	private static ArrayList<Integer>[] adjList;
	private static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; ++i) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		
		adjList = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; ++i) {
			
			adjList[i] = new ArrayList<>();
			
			st = new StringTokenizer(br.readLine());
			int adjN = Integer.parseInt(st.nextToken());
			
			for(int j = 0; j < adjN; ++j) {
				adjList[i].add(Integer.parseInt(st.nextToken()));
			}
		}
		
		ans = Integer.MAX_VALUE;
		boolean[] team = new boolean[N + 1];
		
		dfs(1, team);
		
		if(ans == Integer.MAX_VALUE) {
			System.out.println(-1);
		} else {
			System.out.println(ans);		
		}

	}
	
	private static void dfs(int start, boolean[] team) {
		if(start == N + 1) {
			int cnt = 0;
			for(int i = 1; i <= N; ++i) {
				if(team[i] == true) cnt++;
			}
			
			if(cnt == 0 || cnt == N) return;
			
			if(!possibleOcc(team)) {
				return;
			}
			
			int teamA = 0;
			int teamB = 0;
			
			for(int i = 1; i <= N; ++i) {
				if(team[i]) teamA += population[i];
				else teamB += population[i];
			}
			
			ans = Math.min(ans, Math.abs(teamA - teamB));
			
			return;
		}
		
		dfs(start + 1, team);
		team[start] = true;
		dfs(start + 1, team);
		team[start] = false;
		
	}
	
	//두 덩이가 나오는지 확인
	private static boolean possibleOcc(boolean[] team) {
		boolean[] teamValidation = new boolean[N + 1];
		Queue<Integer> q = new ArrayDeque<>();
		int cnt = 0;
		
		for(int i = 1; i <= N; ++i) {
			if(!teamValidation[i]) {
				if(team[i] == true) {
					teamValidation[i] = true;
					q.offer(i);
					
					while(!(q.isEmpty())) {
						int cur = q.poll();
						
						for(int j = 0; j < adjList[cur].size(); ++j) {
							int ni = adjList[cur].get(j);
							
							if(team[ni] == false) continue;
							if(teamValidation[ni] == true) continue;
							
							teamValidation[ni] = true;
							q.offer(ni);
						}
					}
					cnt++;
				}
				else {
					teamValidation[i] = true;
					q.offer(i);
					
					while(!(q.isEmpty())) {
						int cur = q.poll();
						
						for(int j = 0; j < adjList[cur].size(); ++j) {
							int ni = adjList[cur].get(j);
							
							if(team[ni] == true) continue;
							if(teamValidation[ni] == true) continue;
							
							teamValidation[ni] = true;
							q.offer(ni);
						}
					}
					cnt++;
				}
			}

		}
		
		if(cnt == 2) return true;
		
		return false;
	}
}
