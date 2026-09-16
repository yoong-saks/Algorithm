import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[] cnt = new int[101];

        while(A > 1) {
            cnt[A % B]++;
            A /= B;
        }
        
        int ans = 0;

        for(int i = 0; i < 101; ++i) {
            ans += (cnt[i] * cnt[i]);    
        }
        sb.append(ans);
        System.out.println(sb);
    }
}