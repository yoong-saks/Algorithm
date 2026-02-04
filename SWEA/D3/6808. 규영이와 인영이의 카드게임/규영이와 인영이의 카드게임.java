import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    static int[] k_card = new int[9];

    static boolean[] visited;
    static int win;
    static int lose;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; ++t) {
            win = 0;
            lose = 0;
            visited = new boolean[19];

            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < 9; ++i) {
                k_card[i] = Integer.parseInt(st.nextToken());
                visited[k_card[i]] = true;
            }

            dfs(0, 0, 0);
            System.out.println("#" + t + " " +win + " " + lose);
        }


    }

    static void dfs(int level, int win_sum, int lose_sum) {
        if(level == 9) {
            if(win_sum > lose_sum) {
                win++;
            }
            if(win_sum < lose_sum) {
                lose++;
            }
            return;
        }

        for(int i = 1; i < visited.length; ++i) {
            if(!visited[i]) {

                visited[i] = true;

                int sum = i + k_card[level];
                if(i > k_card[level]) {
                    dfs(level + 1, win_sum, lose_sum + sum);
                } else {
                    dfs(level + 1, win_sum + sum, lose_sum);
                }

                visited[i] = false;
            }
        }
    }
}
