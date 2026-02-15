import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int[][] map;
    private static boolean[][] visited;
    private static int[] honey;

    private static int N, M, C, ans;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); //벌통 크기
            M = Integer.parseInt(st.nextToken()); //한 일꾼이 선택가능한 벌통의 수. 가로로 연속되도록
            C = Integer.parseInt(st.nextToken()); //두 일꾼이 채취가능한 최대 꿀 양

            map = new int[N][N];
            visited = new boolean[N][N];
            honey = new int[M * 2];
            ans = 0;

            for(int i = 0; i < N; ++i) {
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < N; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0, 0, 0);

            System.out.println("#" + t + " " + ans);
        }
    }

    private static void dfs(int cnt, int startI, int startJ) {
        if(cnt == 2) {
            int idx = 0;
            for(int i = 0; i < N; ++i) {
                for(int j = 0; j < N; ++j) {
                    if(visited[i][j]) {
                        for(int k = 0; k < M; ++k) {
                            honey[idx++] = map[i][j + k];
                        }
                    }
                }
            }

            int maxProfit1 = 0;

            for(int i = 0; i < 1 << M; ++i) {
                int sum = 0;
                int profit = 0;
                
                for(int j = 0; j < M; ++j) {
                    if((i & (1 << j)) == (1 << j)) {
                        sum += honey[j];
                        profit += (honey[j] * honey[j]);
                    }
                }

                if(sum > C) continue;
                
                maxProfit1 = Math.max(maxProfit1, profit);
            }

            int maxProfit2 = 0;

            for(int i = 0; i < 1 << M; ++i) {
                int sum = 0;
                int profit = 0;

                for(int j = 0; j < M; ++j) {
                    if((i & (1 << j)) == (1 << j)) {
                        sum += honey[j + M];
                        profit += (honey[j + M] * honey[j + M]);
                    }
                }

                if(sum > C) continue;
                
                maxProfit2 = Math.max(maxProfit2, profit);
            }

            ans = Math.max(ans, maxProfit1 + maxProfit2);
            return;
        }

        for(int i = startI; i < N; ++i) {
            for(int j = (i == startI ? startJ : 0); j + M - 1 < N; ++j) {
                visited[i][j] = true;
                dfs(cnt + 1, i, j + M);
                visited[i][j] = false;
            }
        }
    }
}
