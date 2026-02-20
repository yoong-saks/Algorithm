import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int[][] map = new int[20][20];
	private static int[][] dir = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
	private static int[] vertTop;
	private static int[] horiTop;
	private static int bottom;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		IJ dicePos = null;
		initDice();
		
		dicePos = new IJ(x, y);
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < K; ++i) {
			int movement = Integer.parseInt(st.nextToken());
			//1  동 2 서 3 북 4 남
			
			int ni = dicePos.i + dir[movement - 1][0];
			int nj = dicePos.j + dir[movement - 1][1];
			
			if(!(0 <= ni && ni < N) || !(0 <= nj && nj < M)) continue;
			
			if(movement == 1) moveEast();
			if(movement == 2) moveWest();
			if(movement == 3) moveNorth();
			if(movement == 4) moveSouth();
			
			if(map[ni][nj] == 0) {
				map[ni][nj] = bottom;
			} else {
				bottom = map[ni][nj];
				map[ni][nj] = 0;
			}
			
			dicePos.i = ni;
			dicePos.j = nj;
			
			sb.append(horiTop[1]).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static void moveEast() {
		int tmp = bottom;
		bottom = horiTop[2];
		horiTop[2] = horiTop[1];
		horiTop[1] = horiTop[0];
		vertTop[1] = horiTop[1];
		horiTop[0] = tmp;
	}
	private static void moveWest() {
		int tmp = bottom;
		bottom = horiTop[0];
		horiTop[0] = horiTop[1];
		horiTop[1] = horiTop[2];
		vertTop[1] = horiTop[1];
		horiTop[2] = tmp;
	}
	private static void moveNorth() {
		int tmp = bottom;
		bottom = vertTop[0];
		vertTop[0] = vertTop[1];
		vertTop[1] = vertTop[2];
		horiTop[1] = vertTop[1];
		vertTop[2] = tmp;
	}
	private static void moveSouth() {
		int tmp = bottom;
		bottom = vertTop[2];
		vertTop[2] = vertTop[1];
		vertTop[1] = vertTop[0];
		horiTop[1] = vertTop[1];
		vertTop[0] = tmp;
	}
	
	private static void initDice() {
		vertTop = new int[3];
		horiTop = new int[3];
		
		bottom = 0;
	}
	private static class IJ {
		int i;
		int j;
		
		IJ(int i, int j) {
			this.i = i;
			this.j = j;
		}
	}
}
