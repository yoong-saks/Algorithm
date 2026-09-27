import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 5; ++i) {
            sb.append((char)Integer.parseInt(st.nextToken())).append(" ");
        }

        System.out.println(sb);
    }
}