import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        // ========================================= //
        st = new StringTokenizer(br.readLine());

        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        int cnt = 0;
        
        for(int i = start; i <= end; ++i) {
            int sum = 0;
            
            for(int j = 1; j <= i / 2; ++j) {
                if(i % j == 0) sum += j;
            }
            if(sum == i) cnt++;
        }
        sb.append(cnt);

        // ========================================= //
        System.out.println(sb);
    }
}