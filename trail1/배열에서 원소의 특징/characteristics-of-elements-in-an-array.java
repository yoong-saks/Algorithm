import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        
        int tmp = Integer.parseInt(st.nextToken());

        for(int i = 0; i < 9; ++i) {
            int n = Integer.parseInt(st.nextToken());

            if(n % 3 == 0) {
                sb.append(tmp);
                break;
            }

            tmp = n;
        }

        System.out.println(sb);
    }
}