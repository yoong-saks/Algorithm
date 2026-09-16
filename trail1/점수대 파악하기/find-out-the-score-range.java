import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] cnt = new int[11];
        st = new StringTokenizer(br.readLine());

        while(true) {
            if(!st.hasMoreTokens()) break;
            int score = Integer.parseInt(st.nextToken());
            if(score == 0) break;

            cnt[score / 10]++;
        }

        for(int i = 10; i > 0; --i) {
            sb.append(i * 10).append(" - ").append(cnt[i]).append("\n");
        }

        System.out.println(sb);
    }
}