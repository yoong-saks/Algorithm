import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int tmp = 0;

        sb.append(a).append(" ").append(b).append(" ");
        
        for(int i = 0; i < 8; ++i) {
            sb.append((a + b) % 10).append(" ");
            
            tmp = b;

            b = (a + b) % 10;
            a = tmp;
        }

        System.out.println(sb);
    }
}