import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        String s = Integer.toString(n1 + n2);
        int cnt = 0;

        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) == '1') cnt++;
        }

        sb.append(cnt);

        System.out.println(sb);
    }
}