import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < 10; ++i) {
            String s = st.nextToken();

            if(i == 1 || i == 4 || i == 7) {
                sb.append(s).append(" ");
            }
        }

        System.out.println(sb);
    }
}