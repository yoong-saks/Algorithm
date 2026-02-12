import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static char[][] map;
	private static Tank tank;
	private static int H, W;
	
	private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			
			for(int i = 0; i < H; ++i) {
				String s = br.readLine();
				for(int j = 0; j < W; ++j) {
					map[i][j] = s.charAt(j);
					
					if(map[i][j] == '^' || map[i][j] == '>'
						|| map[i][j] == 'v' || map[i][j] == '<') {
						tank = new Tank(i, j, map[i][j]);
					}
				}
			}
			
			int commandNumber = Integer.parseInt(br.readLine());
			
			String commands = br.readLine();
			
			for(int i = 0; i < commandNumber; ++i) {
				switch(commands.charAt(i)) {
					case 'U':
					case 'D':
					case 'L':
					case 'R':
						doMovement(commands.charAt(i));
						break;
					case 'S':
						doShoot();
						break;
				}
			}
			
			System.out.print("#" + t + " ");
			
			for(int i = 0; i < H; ++i) {
				for(int j = 0; j < W; ++j) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	private static void doMovement(char command) {
		if(command == 'U') {
			map[tank.i][tank.j] = '^';
			tank.d = 0;
		}
		if(command == 'D') {
			map[tank.i][tank.j] = 'v';
			tank.d = 2;
		}
		if(command == 'L') {
			map[tank.i][tank.j] = '<'; 
			tank.d = 3;
		}
		if(command == 'R') {
			map[tank.i][tank.j] = '>';
			tank.d = 1;
		}
		
		int ni = tank.i + dir[tank.d][0];
		int nj = tank.j + dir[tank.d][1];
		
		if(!(0 <= ni && ni < H) || 
		   !(0 <= nj && nj < W) || 
		   !(map[ni][nj] == '.')) {
			return;
		}
		
		map[ni][nj] = map[tank.i][tank.j];
		map[tank.i][tank.j] = '.';
		tank.i = ni;
		tank.j = nj;
	}
	
	private static void doShoot() {
		int ni = tank.i + dir[tank.d][0];
		int nj = tank.j + dir[tank.d][1];
		
		while(true) {
			if(!(0 <= ni && ni < H) || !(0 <= nj && nj < W) || map[ni][nj] == '#') {
				return;
			}
			if(map[ni][nj] == '*') {
				map[ni][nj] = '.';
				
				return;
			}
			ni += dir[tank.d][0];
			nj += dir[tank.d][1];
		}

	}
	
	private static class Tank {
		int i;
		int j;
		int d;
		
		Tank(int i, int j, char d) {
			this.i = i;
			this.j = j;
			
			if(d == '^') this.d = 0;
			if(d == '>') this.d = 1;
			if(d == 'v') this.d = 2;
			if(d == '<') this.d = 3;
		}
	}
}
