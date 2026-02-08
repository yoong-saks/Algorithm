import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    private static int target;
    private static int ans;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; ++t) {
            target = Integer.parseInt(br.readLine());

            ans = 0;

            dfs(0);

            System.out.println(ans);
        }
    }

    private static void dfs(int sum) {
        if(sum >= target) {
            if(sum == target) {
                ans++;
            }
            
            return;
        }

        for(int i = 1; i <= 3; ++i) {
            dfs(sum + i);
        } 
    }
}
