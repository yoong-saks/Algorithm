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

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        for(int i = 1; i <= A; ++i) {
            for(int j = 1; j <= B; ++j) {
                sb.append(i * j).append(" ");
            }
            sb.append("\n");
        }
        
        // ========================================= //
        System.out.println(sb);
    }
}