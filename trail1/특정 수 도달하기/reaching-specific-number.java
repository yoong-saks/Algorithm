import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        
        int sum = 0;
        int cnt = 0;

        for(int i = 0; i < 10; ++i) {
            int n = Integer.parseInt(st.nextToken());    
            if(n >= 250) break;

            sum += n;
            cnt++;
        }

        sb.append(sum).append(" ").append(String.format("%.1f", (float)sum / (float)cnt));

        System.out.println(sb);
    }
}