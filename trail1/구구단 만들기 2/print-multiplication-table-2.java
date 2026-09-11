import java.util.StringTokenizer;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        for(int i = 2; i < 10; i += 2) {
            for(int j = B; j >= A; --j) {
                sb.append(j).append(" * ").append(i).append(" = ").append(i * j);

                if(j != A) sb.append(" / ");
            }

            sb.append("\n");
        }

        System.out.println(sb);
    }
}