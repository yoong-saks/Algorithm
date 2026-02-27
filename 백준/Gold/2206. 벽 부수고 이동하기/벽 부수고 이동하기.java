import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map;
	private static int[][][] visited;
	
	private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws Exception {
		 BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		 StringBuilder sb = new StringBuilder();
		 StringTokenizer st = new StringTokenizer(br.readLine());

		 int N = Integer.parseInt(st.nextToken());
		 int M = Integer.parseInt(st.nextToken());
		 
		 map = new int[N][M];
		 visited = new int[N][M][2];
		 
		 for(int i = 0; i < N; ++i) {
			 String s = br.readLine();
			 for(int j = 0; j < M; ++j) {
				 map[i][j] = s.charAt(j) - '0';
			 }
		 }
		 
		 Queue<IJ> q = new ArrayDeque<>();
		 q.add(new IJ(0, 0, false));
		 visited[0][0][0] = 1;
		 
		 int ans = -1;
		 
		 while(!q.isEmpty()) {
			 IJ cur = q.poll();
			 
			 for(int d = 0; d < 4; ++d) {
				 int ni = cur.i + dir[d][0];
				 int nj = cur.j + dir[d][1];
				 
				 if(ni == N - 1 && nj == M - 1) {
					 ans = visited[cur.i][cur.j][cur.isBreak ? 1 : 0] + 1;
					 q.clear();
					 break;
				 }
				 
				 if(!(0 <= ni && ni < N) || !(0 <= nj && nj < M)) continue; // 경계값
				 if(visited[ni][nj][cur.isBreak ? 1 : 0] != 0) continue;
				 if(map[ni][nj] == 1) {
					 if(!cur.isBreak) {
						 // 부순 적이 없으면
						 visited[ni][nj][1] = visited[cur.i][cur.j][0] + 1;
						 q.add(new IJ(ni, nj, true));
						 
						 continue;
					 }
					 else continue;
				 }
				 
				 visited[ni][nj][cur.isBreak ? 1 : 0] = visited[cur.i][cur.j][cur.isBreak ? 1 : 0] + 1;
				 q.add(new IJ(ni, nj, cur.isBreak));
			 }
		 }
		 
		 if(N == 1 && M == 1) ans = 1;
		 
		 System.out.println(ans);
		 
	}
	
	private static class IJ {
		int i;
		int j;
		boolean isBreak;
		
		IJ(int i, int j, boolean isBreak) {
			this.i = i;
			this.j = j;
			this.isBreak = isBreak;
		}
	}
}