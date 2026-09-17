import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int ans = Integer.MAX_VALUE;
        int prev = Integer.parseInt(st.nextToken());

        for(int i = 1; i < N; ++i) {
            int a = Integer.parseInt(st.nextToken());

            ans = Math.min(ans, a - prev);
            prev = a;
        }

        sb.append(ans);
        
        System.out.println(sb);
    }
}