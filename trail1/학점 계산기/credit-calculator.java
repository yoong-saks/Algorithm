import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        
        double sum = 0;

        for (int i = 0; i < N; ++i) {
            sum += Double.parseDouble(st.nextToken());
        }

        double avg = sum / N;
        
        double roundedAvg = Math.round(avg * 10.0) / 10.0;

        sb.append(String.format("%.1f", roundedAvg)).append("\n");
        if (roundedAvg >= 4.0) sb.append("Perfect");
        else if (roundedAvg >= 3.0) sb.append("Good");
        else sb.append("Poor");

        System.out.println(sb);
    }
}