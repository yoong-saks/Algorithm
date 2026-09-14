import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int ans = 0;

        while(st.hasMoreTokens()) {
            ans += Integer.parseInt(st.nextToken());    
        }

        sb.append(ans);

        System.out.println(sb);
    }
}