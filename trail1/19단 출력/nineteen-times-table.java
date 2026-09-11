import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        // ========================================= //
        for(int i = 1; i <= 19; ++i) {
            for(int j = 1; j <= 19; ++j) {
                sb.append(i).append(" * ").append(j).append(" = ").append(i * j);

                if(j % 2 == 0 || j == 19) sb.append("\n");
                else sb.append(" / ");
            }
        }
        // ========================================= //
        System.out.println(sb);
    }
}