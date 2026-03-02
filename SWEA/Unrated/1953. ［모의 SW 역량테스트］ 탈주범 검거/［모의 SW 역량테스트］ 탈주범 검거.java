import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	private static int[][] map = new int[50][50];
	private static int[][][] pipe = { {{}}, { {-1, 0}, {0, 1}, {1, 0}, {0, -1} }, { {-1, 0}, {1, 0} }, { {0, -1}, {0, 1} }, { {-1, 0}, {0, 1} }, { {1, 0}, {0, 1} }, { {1, 0}, {0, -1} }, { {-1, 0}, {0, -1} } };
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken()); // 맵 세로 크기
			int M = Integer.parseInt(st.nextToken()); // 맵 가로 크기
			int R = Integer.parseInt(st.nextToken()); // 맨홀 세로 위치
			int C = Integer.parseInt(st.nextToken()); // 맨홀 가로 위치
			int L = Integer.parseInt(st.nextToken()); // 걸린 시간
			
			boolean[][] visited = new boolean[N][M];
			
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			visited[R][C] = true;
			Queue<IJ> q = new ArrayDeque<>();
			q.offer(new IJ(R, C, 1));
			
			int ans = 1;
			// 1 상하좌우 2 상하 3 좌우 4 상우 5 하우 6 하좌 7 상좌
			while(!q.isEmpty()) {
				IJ cur = q.poll();
				
				if(cur.depth == L) break;
				
				for(int d = 0; d < pipe[map[cur.i][cur.j]].length; ++d) {
					int ni = cur.i + pipe[map[cur.i][cur.j]][d][0];
					int nj = cur.j + pipe[map[cur.i][cur.j]][d][1];
					
					if(!(0 <= ni && ni < N) || !(0 <= nj && nj < M)) continue;
					if(visited[ni][nj]) continue;
					if(map[ni][nj] == 0) continue;
					if(!(compatible(map[cur.i][cur.j], map[ni][nj], d))) continue;
					visited[ni][nj] = true;
					q.offer(new IJ(ni, nj, cur.depth + 1));
					ans++;
				}
			}
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
	private static boolean compatible(int curPipe, int nPipe, int dir) {
		if(curPipe == 1) {
			// 상우하좌
			if((nPipe == 2) && (dir == 1 || dir == 3)) return false;
			if((nPipe == 3) && (dir == 0 || dir == 2)) return false;
			if((nPipe == 4) && (dir == 0 || dir == 1)) return false;
			if((nPipe == 5) && (dir == 1 || dir == 2)) return false;
			if((nPipe == 6) && (dir == 2 || dir == 3)) return false;
			if((nPipe == 7) && (dir == 0 || dir == 3)) return false;
		}
		if(curPipe == 2) {
			if(nPipe == 3) return false;
			if((nPipe == 4) && (dir == 0)) return false;
			if((nPipe == 5) && (dir == 1)) return false;
			if((nPipe == 6) && (dir == 1)) return false;
			if((nPipe == 7) && (dir == 0)) return false;
		}
		if(curPipe == 3) {
			if(nPipe == 2) return false;
			if((nPipe == 4) && (dir == 1)) return false;
			if((nPipe == 5) && (dir == 1)) return false;
			if((nPipe == 6) && (dir == 0)) return false;
			if((nPipe == 7) && (dir == 0)) return false;
		}
		if(curPipe == 4) {
			if((nPipe == 2) && (dir == 1)) return false;
			if((nPipe == 3) && (dir == 0)) return false;
			if(nPipe == 4) return false;
			if((nPipe == 5) && (dir == 1)) return false;
			if((nPipe == 7) && (dir == 0)) return false;
		}
		if(curPipe == 5) {
			if((nPipe == 2) && (dir == 1)) return false;
			if((nPipe == 3) && (dir == 0)) return false;
			if((nPipe == 4) && (dir == 1)) return false;
			if((nPipe == 5)) return false;
			if((nPipe == 6) && (dir == 0)) return false;
		}
		if(curPipe == 6) {
			if((nPipe == 2) && (dir == 1)) return false;
			if((nPipe == 3) && (dir == 0)) return false;
			if((nPipe == 5) && (dir == 0)) return false;
			if((nPipe == 6)) return false;
			if((nPipe == 7) && (dir == 1)) return false;
		}
		if(curPipe == 7) {
			if((nPipe == 2) && (dir == 1)) return false;
			if((nPipe == 3) && (dir == 0)) return false;
			if((nPipe == 4) && (dir == 0)) return false;
			if((nPipe == 6) && (dir == 1)) return false;
			if(nPipe == 7) return false;
		}
		
		return true;
	}
	private static class IJ {
		int i;
		int j;
		int depth;
		
		IJ(int i, int j, int depth) {
			this.i = i;
			this.j = j;
			this.depth = depth;
		}
	}
}
