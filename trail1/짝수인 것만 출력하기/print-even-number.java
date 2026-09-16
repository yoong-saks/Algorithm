
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; ++i) {
            int a = Integer.parseInt(st.nextToken());

            if(a % 2 == 0) sb.append(a).append(" ");
        }

        System.out.println(sb);
    }
}