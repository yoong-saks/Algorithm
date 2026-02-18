import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    private static int N;
    private static int[][] map = new int[100][100];
    private static int[][] visited = new int[100][100];
    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    // 보급로
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; ++t) {
            N = Integer.parseInt(br.readLine());
            

            for(int i = 0; i < N; ++i) {
                String s = br.readLine();

                for(int j = 0; j < N; ++j) {
                    map[i][j] = s.charAt(j) - '0';
                    visited[i][j] = Integer.MAX_VALUE;
                }
            }

            PriorityQueue<IJ> pq = new PriorityQueue<>((a, b) -> a.cost - b.cost);

            pq.offer(new IJ(0, 0, 0));
            visited[0][0] = 0;
            
            int ans = 0;

            while (!pq.isEmpty()) {
                IJ cur = pq.poll();

                if(cur.cost > visited[cur.i][cur.j]) continue;

                if(cur.i == cur.j && cur.i == N - 1) {
                    ans = cur.cost;
                    
                    break;
                }

                for(int d = 0; d < 4; ++d) {
                    int ni = cur.i + dir[d][0];
                    int nj = cur.j + dir[d][1];

                    if(!(0 <= ni && ni < N) || !(0 <= nj && nj < N)) continue;

                    if(visited[ni][nj] > cur.cost + map[ni][nj]) {
                        visited[ni][nj] = cur.cost + map[ni][nj];

                        pq.offer(new IJ(ni, nj, visited[ni][nj]));
                    }

                }

            }
            System.out.println("#" + t + " " + ans);
        }
    }

    private static class IJ {
        int i;
        int j;
        int cost;

        IJ(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }
}
