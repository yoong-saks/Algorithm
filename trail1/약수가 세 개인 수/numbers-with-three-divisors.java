import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        // ========================================= //
        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());
        int ans = 0;

        for(int i = start; i <= end; ++i) {
            int n = calculator(i);

            if(n == 3) {
                ans++;
            }

        }

        sb.append(ans);
        
        // ========================================= //
        System.out.println(sb);
    }

    private static int calculator(int n) {
        int cnt = 0;
        for(int i = 1; i <= Math.sqrt(n); ++i) {
            if(n % i == 0) {
                cnt++;
                if(i != n / i) cnt++;
            }
            
        }

        return cnt;
    }
}