import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//Ladder1
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
		
		int[][] ladder = new int[100][100];
		
		for(int t = 1; t <= 10; ++t) {
			IJ bot = null;
			
			int T = Integer.parseInt(br.readLine());
			
			for(int i = 0; i < 100; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				for(int j = 0; j < 100; ++j) {
					ladder[i][j] = Integer.parseInt(st.nextToken());
					
					if(ladder[i][j] == 2) {
						bot = new IJ(i, j);
					}
				}
			}
			
			while(bot.i > 0) {
				int dir = -1;
				ladder[bot.i][bot.j] = 0;
				
				for(int d = 0; d < 2; ++d) {
					int nj = bot.j + (dir *= -1);
					
					if(!(0 <= nj && nj < 100)) continue;
					if(ladder[bot.i][nj] == 0) continue;
					
					
					bot.j = nj;
				}
				
				if(ladder[bot.i][bot.j] == 0) {
					bot.i -= 1;
				}
			}
			
			System.out.println("#" + T + " " + bot.j);
		}
		
		

	}

}
