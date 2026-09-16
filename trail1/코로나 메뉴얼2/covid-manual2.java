import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[] cnt = new int[4];

        for(int i = 0; i < 3; ++i) {
            st = new StringTokenizer(br.readLine());

            if(st.nextToken().equals("Y")) {
                if(Integer.parseInt(st.nextToken()) >= 37) {
                    cnt[0]++;
                } else {
                    cnt[2]++;
                }
            } else {
                if(Integer.parseInt(st.nextToken()) >= 37) {
                    cnt[1]++;
                } else {
                    cnt[3]++;
                }
            }


        }

        for(int j = 0; j < 4; ++j) {
            sb.append(cnt[j]).append(" ");

        }

        if(cnt[0] > 1) sb.append("E");
        System.out.println(sb);
    }
}