import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;
        int lenghts = 0;

        for(int i = 0; i < N; ++i) {
            String s = br.readLine();

            if(s.charAt(0) == 'a') cnt++;
            lenghts += s.length();
        }

        sb.append(lenghts).append(" ").append(cnt);

        System.out.println(sb);
    }
}