import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        // ========================================= //
        int N = Integer.parseInt(br.readLine());

        for(int T = 0; T < N; ++T) {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int ans = 1;
            for(int i = a; i <= b; ++i) {
                ans *= i;
            }

            sb.append(ans).append("\n");
        }
        // ========================================= //
        System.out.println(sb);
    }
}