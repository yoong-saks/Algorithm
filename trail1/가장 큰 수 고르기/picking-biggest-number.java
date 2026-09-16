import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int max = 0;

        for(int i = 0; i < 10; ++i) {
            int a = Integer.parseInt(st.nextToken());

            if(max < a) max = a;
        }

        sb.append(max);

        System.out.println(sb);
    }
}