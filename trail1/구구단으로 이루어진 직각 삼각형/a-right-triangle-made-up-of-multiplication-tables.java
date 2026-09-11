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

        for(int i = 1; i <= N; ++i) {
            for(int j = 1; i + j <= N + 1; ++j) {
                sb.append(i).append(" * ").append(j).append(" = ").append(i * j);

                if(i + j < N + 1) sb.append(" / ");
                else sb.append("\n");
            }
        }
        // ========================================= //
        System.out.println(sb);
    }
}