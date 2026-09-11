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
                if(i % 2 == 0) {
                    sb.append(++cnt).append(" ");
                } else {
                    sb.append(cnt += 2).append(" ");
                }
            }
            sb.append("\n");
        }
        // ========================================= //
        System.out.println(sb);
    }
}