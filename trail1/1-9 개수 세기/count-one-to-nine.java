import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] cnt = new int[10];

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; ++i) {
            int a = Integer.parseInt(st.nextToken());

            cnt[a]++;
        }

        for(int i = 1; i < 10; ++i) {
            sb.append(cnt[i]).append("\n");
        }
        
        System.out.println(sb);
    }
}