import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(st.hasMoreTokens()) {
            sb.append(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        while(st.hasMoreTokens()) {
            sb.append(st.nextToken());
        }

        System.out.println(sb);
    }
}