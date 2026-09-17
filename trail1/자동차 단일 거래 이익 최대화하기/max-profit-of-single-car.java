import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        
        int minPrice = Integer.parseInt(st.nextToken());
        int ans = 0;

        for(int i = 1; i < N; ++i) {
            int a = Integer.parseInt(st.nextToken());
            ans = Math.max(ans, a - minPrice);
            minPrice = Math.min(minPrice, a);
        }

        sb.append(ans);

        System.out.println(sb);
    }
}