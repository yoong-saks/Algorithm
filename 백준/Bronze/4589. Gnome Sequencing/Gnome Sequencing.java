import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("Gnomes:\n");
		
		int N = Integer.parseInt(br.readLine());
		int[][] map = new int[N][N];
		
		for(int i = 0; i < N; ++i) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int cnt = 0;
			map[i][0] = Integer.parseInt(st.nextToken());
			
			for(int j = 1; j < 3; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] > map[i][j - 1]) cnt++;
				if(map[i][j] < map[i][j - 1]) cnt--;
			}
			
			if(Math.abs(cnt) == 2) sb.append("Ordered\n");
			else sb.append("Unordered\n");
		}
		
		System.out.println(sb);
	}
}
