import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < 5; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 3; ++j) {
                char c = st.nextToken().charAt(0);

                c = Character.toUpperCase(c);
                sb.append(c).append(" ");    
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}