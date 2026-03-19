import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int r = 0;
		int c = 0;
		int maxTurn = Integer.MIN_VALUE;
		
		for(int i = 0; i < 10; ++i) {
			
			st = new StringTokenizer(br.readLine());
			
			for(int j = 0; j < 10; ++j) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num > maxTurn) {
					maxTurn = num;
					r = i;
					c = j;
				}
			}
		}
		
		int[][] map = new int[10][10];
		
		map[r][c] = 1;
		
		for(int i = 2; i < 7; i += 2) {
			map[r][(c + i) % 10] = 1;
		}
		
		for(int i = 0; i < 7; i += 3) {
			map[(r + 2) % 10][i] = 1;
			map[(r + 2) % 10][i + 1] = 1;
		}
		
		for(int i = 0; i < 5; i += 4) {
			map[(r + 4) % 10][i] = 1;
			map[(r + 4) % 10][i + 1] = 1;
			map[(r + 4) % 10][i + 2] = 1;
		}
		
		map[(r + 6) % 10][0] = 1;
		map[(r + 6) % 10][1] = 1;
		map[(r + 6) % 10][2] = 1;
		map[(r + 6) % 10][3] = 1;
		
		for(int i = 0; i < 10; ++i) {
			for(int j = 0; j < 10; ++j) {
				if(map[i][j] == 1) sb.append("#");
				else sb.append(".");
			}
			sb.append("\n");
		}
		
		System.out.println(sb);
	}

}
