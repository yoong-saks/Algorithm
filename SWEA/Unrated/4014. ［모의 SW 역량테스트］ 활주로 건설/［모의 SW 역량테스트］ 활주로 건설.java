import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int N; // 맵의 크기 (6 ~ 20)
	private static int X; // 경사로의 길이
	private static int[][] map = new int[20][20];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			X = Integer.parseInt(st.nextToken());
			
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < N; ++j) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int ans = 0;
			
			// 가로 검사
			for(int i = 0; i < N; ++i) {
				if(check(map[i])) ans++;
			}
			
			// 세로 검사
			for(int j  = 0; j < N; ++j) {
				int[] col = new int[N];
				for(int i = 0; i < N; ++i) col[i] = map[i][j];
				if(check(col)) ans++;
			}
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		
		System.out.println(sb);
	}
	
	// 해당 길이 활주로가 될 수 있는지 검사
	private static boolean check(int[] line) {
		boolean[] construct = new boolean[N]; //공사완료 여부
		
		for(int i = 0; i < N - 1; ++i) {
			if(line[i] == line[i + 1]) continue; // 높이가 같으면 고려x
			if(Math.abs(line[i] - line[i + 1]) > 1) return false; // 높이가 2이상 차이나면 활주로가 아님
			if(line[i] == line[i + 1] - 1) { // 오르막길을 만났을 때
				//왼쪽으로 경사로 설치
				for(int j = i; j > i - X; --j) {
					//범위를 벗어나거나 높이가 평평하지 않거나 이미 경사로가 있으면 활주로가 아님
					if(j < 0 || line[j] != line[i] || construct[j]) return false;
					construct[j] = true;
				}
			}
			else if(line[i] == line[i + 1] + 1) { // 내리막길을 만났을 때
				//오른쪽으로 경사로 설치
				for(int j = i + 1; j <= i + X; ++j) {
					//범위를 벗어나거나 높이가 평평하지 않거나 이미 경사로가 있으면 활주로가 아님
					if(j >= N || line[j] != line[i + 1] || construct[j]) return false;
					construct[j] = true;
				}
			}
		}
		
		return true; //모두 끝내면 활주로가 된다는 것.
	}

}
