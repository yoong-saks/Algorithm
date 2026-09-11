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

        for(int i = 0; i < N; ++i) {
            for(int j = 1; j <= N; ++j) {
                if(i % 2 == 0) {
                    sb.append(i * N + j).append(" ");
                } else {
                    sb.append(N * (i + 1) - (j - 1)).append(" ");
                }
            }
            sb.append("\n");
        }
        
        
        // ========================================= //
        System.out.println(sb);
    }
}