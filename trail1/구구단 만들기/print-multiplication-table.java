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

        

        for(int i = 1; i <= 9; ++i) {
            int cnt = B;
            
            for(int j = B; j >= A; --j) {
                if(j % 2 != 0) continue;

                sb.append(j).append(" * ").append(i).append(" = ").append(j * i);

                if(j != A) sb.append(" / ");
            }

            sb.append("\n");
        }
        // ========================================= //
        System.out.println(sb);
    }
}