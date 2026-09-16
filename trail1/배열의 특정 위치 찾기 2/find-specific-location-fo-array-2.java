import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int even = 0;
        int odd = 0;

        for(int i = 0; i < 10; ++i) {
            int n = Integer.parseInt(st.nextToken());
            
            if(i % 2 == 0) {
                even += n;
            } else {
                odd += n;
            }
        }
        int ans = Math.max(even, odd) - Math.min(even, odd);

        sb.append(ans);
        System.out.println(sb);
    }
}