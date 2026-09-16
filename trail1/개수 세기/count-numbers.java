import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        int cnt = 0;

        for(int i = 0; i < N; ++i) {
            int a = Integer.parseInt(st.nextToken());

            if(a == M) cnt++;
        }

        sb.append(cnt);
        System.out.println(sb);
    }
}