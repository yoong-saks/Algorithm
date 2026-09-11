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

        for(int i = N; i > 0; --i) {
            for(int j = i; j <= N; ++j) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }
        // ========================================= //
        System.out.print(sb);
    }
}