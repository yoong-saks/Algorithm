import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    private static int[][] gears = new int[4][8];
    private static boolean[] visited = new boolean[4];

    // 특이한 자석
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; ++t) {
            

            int K = Integer.parseInt(br.readLine()); // 돌리는 횟수

            for(int i = 0; i < 4; ++i) {
                st = new StringTokenizer(br.readLine());

                for(int j = 0; j < 8; ++j) {
                    gears[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            
            for(int i = 0; i < K; ++i) {
                st = new StringTokenizer(br.readLine());
                
                Arrays.fill(visited, false);

                int N = Integer.parseInt(st.nextToken()) - 1; // 돌리려는 번호
                int R = Integer.parseInt(st.nextToken()); // 돌리는 방향
                
                visited[N] = true;
                rcs(N, R);
            }

            // 본인의 왼쪽 오른쪽 탐색.. 한 번 왼쪽 간애는 오른쪽으로 다시 오면 안됨
            // 모두 탐색 후, 돌릴 수 있는 애들만 돌림.
            // 한 번 넘어갈 때마다, 회전 방향은 반대로 바뀜
            
            int ans = scoreCalculator();

            System.out.println("#" + t + " " + ans);
        }
    }

    private static void rcs(int n, int r) {
        int nl = n - 1; // 왼쪽 번호
        int nr = n + 1; // 오른쪽 번호

        if(0 <= nl && !visited[nl]) { // 본인의 왼쪽 기어가 0 이상이며 방문하지 않았다면
            // 왼쪽이 돌릴 수 있다면..
            if(checkLeft(n)) {
                visited[nl] = true;
                rcs(nl, r * -1);
            }
        }

        if(nr < 4 && !visited[nr]) { // 본인의 오른쪽 기어가 4 이하이며 방문하지 않았다면
            if(checkRight(n)) {
                visited[nr] = true;
                rcs(nr, r * -1);
            }
        }

        //모두 확인이 끝나고 돌릴수있는것들만 돌림
        rotateGear(n, r);

    }
    private static int scoreCalculator() {
        int score = 0;
        for(int i = 0, times = 1; i < 4; ++i, times *= 2) {
            if(gears[i][0] == 1) score += times;
        }

        return score;
    }

    private static void rotateGear(int n, int r) {
        if(r == 1) { // 시계 방향
            int tmp = gears[n][7];

            for(int i = 7; i > 0; --i) {
                gears[n][i] = gears[n][i - 1];
            }
            gears[n][0] = tmp;
        }

        if(r == -1) {
            int tmp = gears[n][0];

            for(int i = 0; i < 7; ++i) {
                gears[n][i] = gears[n][i + 1];
            }
            gears[n][7] = tmp;
        }
    }

    private static boolean checkLeft(int n) {
        return gears[n][6] != gears[n - 1][2];
    }

    private static boolean checkRight(int n) {
        return gears[n][2] != gears[n + 1][6];
    }
}
