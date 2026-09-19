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

        String s1 = st.nextToken();
        String s2 = st.nextToken();

        if(s1.length() > s2.length()) {
            sb.append(s1).append(" ").append(s1.length());
        } else if(s1.length() < s2.length()) {
            sb.append(s2).append(" ").append(s2.length());
        } else {
            sb.append("same");
        }

        System.out.println(sb);
    }
}