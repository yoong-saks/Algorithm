import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {    
    private static int N, K, maxHeight, maxDepth;
    private static int[][] map;
    private static boolean[][] visited;

    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            
            N = Integer.parseInt(st.nextToken()); // 맵 한변의 길이
            K = Integer.parseInt(st.nextToken()); // 최대 공사가능 깊이
            map = new int[N][N];
            visited = new boolean[N][N];
            maxHeight = 0;
            maxDepth = 0;

            for(int i = 0; i < N; ++i) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                    maxHeight = Math.max(maxHeight, map[i][j]);
                }
            }

            for(int i = 0; i < N; ++i) {
                for(int j = 0; j < N; ++j) {
                    if(map[i][j] == maxHeight) {
                        visited[i][j] = true;
                        btk(1, i, j, false);
                        visited[i][j] = false;
                    }
                }
            }

            System.out.println("#" + t + " " + maxDepth);
        }
    }

    private static void btk(int depth, int startI, int startJ, boolean construct) {
        maxDepth = Math.max(maxDepth, depth);

        for(int d = 0; d < 4; ++d) {
            int ni = startI + dir[d][0];
            int nj = startJ + dir[d][1];
            
            if(!(0 <= ni && ni < N) || !(0 <= nj && nj < N)) continue; // 맵 경계
            if(visited[ni][nj]) continue; // 방문했던 곳은 안 감

            if(map[ni][nj] >= map[startI][startJ]) { // 다음이 나보다 클 때,
                if(map[ni][nj] - K >= map[startI][startJ]) continue; // 최대로 깎아도 나보다 크면 고려대상 아님

                if(!construct) { // 공사를 안 했을 때만,
                    int tmp = map[ni][nj];

                    visited[ni][nj] = true;
                    map[ni][nj] = map[startI][startJ] - 1;
                    btk(depth + 1, ni, nj, true);
                    visited[ni][nj] = false;
                    map[ni][nj] = tmp;
                }
            } else { // 다음이 나보다 작을 때,
                visited[ni][nj] = true;
                btk(depth + 1, ni, nj, construct); // 기존의 공사상태 그대로 들고 감
                visited[ni][nj] = false;
            }
        }
    }
}
