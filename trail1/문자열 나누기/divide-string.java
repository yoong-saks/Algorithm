import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2;

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        sb2 = new StringBuilder();

        for(int i = 0; i < N; ++i) {
            String s = st.nextToken();
            
            for(int j = 0; j < s.length(); ++j) {
                if(sb2.toString().length() == 5) {
                    sb.append(sb2.toString()).append("\n");
                    sb2 = new StringBuilder();
                }

                sb2.append(s.charAt(j));
            }
        }
        sb.append(sb2.toString());
        System.out.println(sb);
    }
}