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
        int num = 2;

        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < N; ++j) {
                sb.append(num).append(" ");
                num += 2;

                if(num == 10) num = 2;
            }
            sb.append("\n");
        }
        
        
        // ========================================= //
        System.out.println(sb);
    }
}