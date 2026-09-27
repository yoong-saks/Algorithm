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

        int i = (int)st.nextToken().charAt(0);
        char c = (char)Integer.parseInt(st.nextToken());

        sb.append(i).append(" ").append(c);

        System.out.println(sb);
    }
}