import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    // 햄버거 다이어트 (조합)

    private static int N, ans, L;
    private static int[][] foodList;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // 햄버거의 개수 1 <= N <= 20
            L  = Integer.parseInt(st.nextToken()); // 제한 칼로리 1 <= L <= 10000

            foodList = new int[N][2];

            for(int i = 0; i < N; ++i) {
                st = new StringTokenizer(br.readLine());
                foodList[i][0] = Integer.parseInt(st.nextToken());
                foodList[i][1] = Integer.parseInt(st.nextToken());
            }

            ans = 0;

            dfs(0, 0, 0);

            System.out.println("#" + t + " " + ans);
        }
    }

    private static void dfs(int start, int calories, int score) {
        if(L < calories) return;
        
        ans = Math.max(ans, score);

        for(int i = start; i < N; ++i) {
            dfs(i + 1, calories + foodList[i][1], score + foodList[i][0]);
        }
    }
}
