import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        Double avg = 0.0;
        for(int i = 0; i < 8; ++i) {
            avg += Double.parseDouble(st.nextToken());
        }

        avg /= 8.0;

        sb.append(String.format("%.1f", avg));

        System.out.println(sb);
    }
}