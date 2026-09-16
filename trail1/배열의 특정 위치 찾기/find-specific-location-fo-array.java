import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int sum = 0;
        double avg = 0;
        int cnt = 0;


        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= 10; ++i) {
            int n = Integer.parseInt(st.nextToken());

            if(i % 2 == 0) sum += n;
            if(i % 3 == 0) {
                avg += n;
                cnt++;
            }
        }

        sb.append(sum).append(" ").append(String.format("%.1f", avg / cnt));
        System.out.println(sb);
    }
}