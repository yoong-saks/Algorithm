import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    private static int N;
    private static int M;
    private static int K;
    private static int[][] map;
    private static boolean[][] visited;
    private static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        visited = new boolean[N][M];
        map = new int[N][M];

        for(int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        ans = -2147483648;
        combination(0, 0, 0);

        System.out.println(ans);
    }

    private static void combination(int cnt, int start, int sum) {
        if(cnt == K) {
            ans = Math.max(ans, sum);
            
            return;
        }
        
        for(int i = start; i < (N * M); i++) {
            if((i / M) - 1 >= 0 && visited[(i / M) - 1][i % M]) {
                continue;
            }
            if((i % M) - 1 >= 0 && visited[i / M][(i % M) - 1]) {
                continue;
            }
            visited[i / M][i % M] = true;
            combination(cnt + 1, i + 1, sum + map[i / M][i % M]);
            visited[i / M][i % M] = false;
        }
    }
}
