import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static char[][] map;
    static boolean[][][] visited;
    static int[] di = {-1, 0, 1, 0};
    static int[] dj = {0, 1, 0, -1};

    static class IJK {
        int i;
        int j;
        int k; //bitmasking
        int cnt;

        IJK(int i, int j, int k, int cnt) {
            this.i = i;
            this.j = j;
            this.k = k;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        map = new char[N][M];
        visited = new boolean[1 << 6][N][M]; // 모든 열쇠의 경우의수만큼 차원이 생김.
        
        Queue<IJK> q = new ArrayDeque<>();
        
        for(int i = 0; i < N; ++i) {
            String s = br.readLine();
            for(int j = 0; j < M; ++j) {
                map[i][j] = s.charAt(j);

                if(map[i][j] == '0') {
                    q.offer(new IJK(i, j, 0, 0));
                }
            }
        }

        visited[0][q.peek().i][q.peek().j] = true;
        
        int ans = -1;
        //bfs
        while(!q.isEmpty() && ans == -1) {
            IJK cur = q.poll();

            if(map[cur.i][cur.j] == '1') {
                ans = cur.cnt;
                continue;
            }

            for(int d = 0; d < 4; ++d) {
                int ni = cur.i + di[d];
                int nj = cur.j + dj[d];
                int nk = cur.k;

                if(!(0 <= ni && ni < N) || !(0 <= nj && nj < M) || map[ni][nj] == '#') continue; // 경계값


                if(map[ni][nj] >= 'A' && map[ni][nj] <= 'F') { // 문을 만나면
                    if((cur.k & (1 << map[ni][nj] - 'A')) == 0) continue; // 현재 내가 키를 가지고 있지않은 세계관이면 벽임.
                }

                
                if(map[ni][nj] >= 'a' && map[ni][nj] <= 'f') {
                    nk = cur.k | (1 << (map[ni][nj] - 'a'));
                }

                if(visited[nk][ni][nj]) continue;
                
                q.offer(new IJK(ni, nj, nk, cur.cnt + 1));
                visited[nk][ni][nj] = true;

            }
        }

        System.out.println(ans);

    }
}