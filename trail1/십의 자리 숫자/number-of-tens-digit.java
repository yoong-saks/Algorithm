import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] cnt = new int[10];
        st = new StringTokenizer(br.readLine());

        while(true) {
            if(!st.hasMoreTokens()) break;
            int a = Integer.parseInt(st.nextToken());
            if(a == 0) break;

            cnt[a /= 10]++;
        }

        for(int i = 1; i < 10; ++i) {
            sb.append(i).append(" - ").append(cnt[i]).append("\n");
        }

        System.out.println(sb);
    }
}