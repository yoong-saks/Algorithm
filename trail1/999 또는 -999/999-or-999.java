import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        while(true) {
            if(!st.hasMoreTokens()) break;
            int a = Integer.parseInt(st.nextToken());
            if(a == 999 || a == -999) break;

            if(max < a) max = a;
            if(min > a) min = a;
        }

        sb.append(max).append(" ").append(min);

        System.out.println(sb);
    }
}