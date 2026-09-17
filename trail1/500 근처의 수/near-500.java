import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int max = 0;
        int min = 1001;

        for(int i = 0; i < 10; ++i) {
            int a = Integer.parseInt(st.nextToken());

            if(max < a && a < 500) max = a;
            if(min > a && a > 500) min = a;
        }

        sb.append(max).append(" ").append(min);

        System.out.println(sb);
    }
}