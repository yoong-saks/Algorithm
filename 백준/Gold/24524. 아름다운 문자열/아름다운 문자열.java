import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        String T = br.readLine();
        
        int[] dp = new int[T.length()];
        
        for (int i = 0; i < S.length(); i++) {
            char c = S.charAt(i);
            int idx = T.indexOf(c); 
            
            if (idx == -1) continue;
            
            if (idx == 0) {
                dp[0]++; 
            } else if (dp[idx - 1] > 0) {
                
                dp[idx - 1]--;
                dp[idx]++;
            }
        }
        
        System.out.println(dp[T.length() - 1]);
    }
}