import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int sum = 0;
        int cnt = 0;

        while(true) {
            if(!st.hasMoreTokens()) break;

            int n = Integer.parseInt(st.nextToken());

            if(n == 0) break;

            cnt++;
            sum += n;
        }
        
        double avg = (double) sum / cnt;

        System.out.printf("%d %.1f\n", sum, avg);
    }
}