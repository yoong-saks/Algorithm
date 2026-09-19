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
        int offset = 1;

        while(st.hasMoreTokens()) {
            String s = st.nextToken();
            if(offset % 2 == 1) {
                sb.append(s).append("\n");
            }
            offset++;
        }
        System.out.println(sb);
    }
}