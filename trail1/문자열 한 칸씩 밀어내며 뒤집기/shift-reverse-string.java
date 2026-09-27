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

        StringBuilder s = new StringBuilder();
        s.append(st.nextToken());

        int Q = Integer.parseInt(st.nextToken());

        for(int i = 0; i < Q; ++i) {
            int M = Integer.parseInt(br.readLine());

            if(M == 1) {
                char first = s.charAt(0);
                s.deleteCharAt(0);
                s.append(first);

                sb.append(s.toString()).append("\n");
            }
            if(M == 2) {
                char last = s.charAt(s.length() - 1);
                s.deleteCharAt(s.length() - 1);
                s.insert(0, last);

                sb.append(s.toString()).append("\n");
            }
            if(M == 3) {
                sb.append(s.reverse());
                sb.append("\n");
            }
        }

        System.out.println(sb);
    }
}