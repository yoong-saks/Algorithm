import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int sum = 0;

        st = new StringTokenizer(br.readLine());

        for(int i = 1; i <= 10; ++i) {
            int n = Integer.parseInt(st.nextToken());

            if(i == 3 || i == 5 || i == 10) {
                sum += n;
            }
        }
        sb.append(sum);
        
        System.out.println(sb);
    }
}