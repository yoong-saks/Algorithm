import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        String origin = st.nextToken();

        int cnt = 0;
        for(int i = 0; i < n; ++i) {
            if(origin.equals(br.readLine())) cnt++;
        }

        sb.append(cnt);

        System.out.println(sb);
    }
}