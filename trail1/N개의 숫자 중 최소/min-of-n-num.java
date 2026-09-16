import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        int min = Integer.MAX_VALUE;
        int cnt = 0;

        for(int i = 0; i < N; ++i) {
            int a = Integer.parseInt(st.nextToken());

            if(min > a) {
                min = a;
                cnt = 0;
            }
            if(min == a) {
                cnt++;
            }
        }

        sb.append(min).append(" ").append(cnt);

        System.out.println(sb);
    }
}