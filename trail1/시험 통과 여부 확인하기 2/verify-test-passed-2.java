import java.util.*;
import java.io.*;


public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int cnt = 0;

        for(int i = 0; i < N; ++i) {
            double sum = 0;
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 4; ++j) {
                sum += Double.parseDouble(st.nextToken());
            }

            if(sum / 4 >= 60.0) {
                sb.append("pass").append("\n");
                cnt++;
            }
            else {
                sb.append("fail").append("\n");
            }
        }

        sb.append(cnt);

        System.out.println(sb);
    }
}