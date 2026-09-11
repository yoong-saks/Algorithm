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
            if(i % 2 == 0) {
                int cnt = N;
                
                for(int j = 0; j < N; ++j) {
                    sb.append(cnt--);
                }
            } else {
                int cnt = 1;
                
                for(int j = 0; j < N; ++j) {
                    sb.append(cnt++);
                }
            }

            sb.append("\n");
        }
        
        
        // ========================================= //
        System.out.println(sb);
    }
}