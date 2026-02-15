import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int[] ticketPrice = new int[4]; //1일 1달 3달 1년
    private static int[] dp = new int[13];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int i = 0; i < 4; ++i) {
                ticketPrice[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 1; i < 13; ++i) {
                dp[i] = Integer.parseInt(st.nextToken());

                int n1 = dp[i - 1] + dp[i] * ticketPrice[0];
                int n2 = dp[i - 1] + ticketPrice[1];
                int n3 = dp[i - 3 < 0 ? 0 : i - 3] + ticketPrice[2];

                dp[i] = Math.min(n1, Math.min(n2, n3));
            }

            System.out.println("#" + t + " " + Math.min(dp[12], ticketPrice[3]));
            
        }
    }
}
