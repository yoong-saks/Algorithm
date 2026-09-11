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
        int cnt = 1;

        for(int i = 1; i <= N; ++i) {
            for(int j = 0; j < i - 1; ++j) {
                sb.append("  ");
            }
            for(int j = 1; j <= N - i + 1; ++j) {
                sb.append(cnt++).append(" ");

                if(cnt == 10) cnt = 1;
            }

            sb.append("\n");
        }
        // ========================================= //
        System.out.println(sb);
    }
}