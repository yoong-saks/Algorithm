import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int sum = 0;

        for(int i = 0; i < 4; ++i) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 4; ++j) {
                int a = Integer.parseInt(st.nextToken());

                if(j <= i) sum += a;
            }
        }

        sb.append(sum);

        System.out.println(sb);
    }
}