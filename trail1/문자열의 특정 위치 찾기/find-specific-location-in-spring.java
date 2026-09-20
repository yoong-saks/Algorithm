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

        String s = st.nextToken();
        String c = st.nextToken();
        if(s.indexOf(c) == -1) {
            sb.append("No");
        } else {
            sb.append(s.indexOf(c));
        }
        System.out.println(sb);
    }
}