import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int n1 = Integer.parseInt(st.nextToken());
        int n2 = Integer.parseInt(st.nextToken());

        if(n2 > n1) sb.append("No");
        else {
            StringBuilder sb1 = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n1; ++i) {
                sb1.append(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < n2; ++i) {
                sb2.append(st.nextToken());
            }

            int n = sb1.indexOf(sb2.toString());

            if(n == -1) sb.append("No");
            else sb.append("Yes");
        }
        System.out.println(sb);
    }
}