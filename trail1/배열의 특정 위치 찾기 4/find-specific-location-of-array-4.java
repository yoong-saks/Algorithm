import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int cnt = 0;
        int sum = 0;

        while(true) {
            if(!st.hasMoreTokens()) break;
            
            int n = Integer.parseInt(st.nextToken());

            if(n == 0) break;

            if(n % 2 == 0) {
                cnt++;
                sum += n;
            }
        }

        sb.append(cnt).append(" ").append(sum);

        System.out.println(sb);
    }
}