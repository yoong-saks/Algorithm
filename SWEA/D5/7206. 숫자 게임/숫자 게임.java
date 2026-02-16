import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    private static int[] dp = new int[100000];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int i = 10; i < dp.length; ++i) {
            dp[i] = 1 + calculateMax(i);
        }

        for(int t = 1; t <= T; ++t) {
            int N = Integer.parseInt(br.readLine());

            System.out.println("#" + t + " " + dp[N]);
        }
    }

    private static int calculateMax(int n) {
        int maxValue = 0;
        String s = Integer.toString(n);

        for(int i = 0; i < 1 << (s.length() - 1); ++i) { // bitmasking
            int product = 1;
            int lastIdx = 0;
            for(int j = 0; j < s.length() - 1 ; ++j) {
                if((i & (1 << j)) != 0) {
                    // 칸막이가 있으면 현재 위치까지 잘라서 곱함
                    product *= Integer.parseInt(s.substring(lastIdx, j + 1));
                    lastIdx = j + 1;
                }
            }

            product *= Integer.parseInt(s.substring(lastIdx));

            maxValue = Math.max(maxValue, dp[product]);
        }

        return maxValue;
    }
}
