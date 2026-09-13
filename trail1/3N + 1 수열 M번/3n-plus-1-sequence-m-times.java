import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; ++t) {
            int N = Integer.parseInt(br.readLine());
            int cnt = 0;
            while(N != 1) {
                if(N % 2 == 0) {
                    N /= 2;
                } else {
                    N *= 3;
                    N += 1;
                }
                cnt++;
            }

            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }
}