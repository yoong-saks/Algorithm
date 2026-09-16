import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        while(true) {
            if(!st.hasMoreTokens()) break;

            int a = Integer.parseInt(st.nextToken());
            
            if(a == 0) break;

            if(a % 2 == 0) sb.append(a / 2).append(" ");
            else sb.append(a + 3).append(" ");
        }

        System.out.println(sb);
    }
}