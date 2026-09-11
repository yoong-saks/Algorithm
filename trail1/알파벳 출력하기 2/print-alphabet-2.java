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
        int cnt = 0;

        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < N; ++j) {
                if(j < i) sb.append("  ");
                else sb.append((char)(cnt++ + 'A')).append(" ");

                if(cnt + 'A' > 'Z') cnt = 0;
            }
            sb.append("\n");
        }
        // ========================================= //
        System.out.println(sb);
    }
}