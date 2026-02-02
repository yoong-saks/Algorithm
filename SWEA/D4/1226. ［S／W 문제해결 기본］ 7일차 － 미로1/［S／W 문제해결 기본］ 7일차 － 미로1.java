import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Solution {
	static class IJ {
		int i;
		int j;	
		
		IJ(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] map = new int[16][16];
		int[] di = {-1, 0, 1, 0};
		int[] dj = {0, 1, 0, -1};
		
		

		for(int t = 1; t <= 10; ++t) {
			int T = Integer.parseInt(br.readLine());
			
			int ans = 0;
			Queue<IJ> q = new LinkedList<>();
			
			for(int i = 0; i < 16; ++i) {
				String s = br.readLine();
				
				for(int j = 0; j < 16; ++j) {
					int num = s.charAt(j) - '0';
					map[i][j] = num;
					
					if(num == 2) {
						q.offer(new IJ(i, j));
					}
				}
			}
			
			while(!q.isEmpty() && ans == 0) {
				IJ cur = q.poll();
				for(int d = 0; d < 4; ++d) {
					int ni = cur.i + di[d];
					int nj = cur.j + dj[d];
					
					if(!(0 <= ni && ni < 16) || !(0 <= nj && nj < 16) || map[ni][nj] != 0) {
						if(map[ni][nj] == 3) {
							ans = 1;
							break;
						}
						
						continue;
					}
					

					
					q.offer(new IJ(ni, nj));
					map[ni][nj] = 1;
				}
				
			}
			
			System.out.println("#" + t + " " + ans);
		}
		
	}
}
