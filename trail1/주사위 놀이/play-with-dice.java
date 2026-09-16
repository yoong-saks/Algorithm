import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int[] cnt = new int[7];

        for(int i = 0; i < 10; ++i) {
            cnt[Integer.parseInt(st.nextToken())]++;
        }

        for(int i = 1; i < 7; ++i) {
            sb.append(i).append(" - ").append(cnt[i]).append("\n");
        }
        System.out.println(sb);
    }
}