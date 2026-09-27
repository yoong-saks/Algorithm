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

        char c1 = st.nextToken().charAt(0);
        char c2 = st.nextToken().charAt(0);

        sb.append((int)c1 + (int)c2).append(" ").append(Math.max(c1, c2) - Math.min(c1, c2));

        System.out.println(sb);
    }
}