import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        
        int[][] arr = new int[2][4];

        for(int i = 0; i < 2; ++i) {
            st = new StringTokenizer(br.readLine());
            int sum = 0;

            for(int j = 0; j < 4; ++j) {
                int a = Integer.parseInt(st.nextToken());

                arr[i][j] = a;
                sum += a;
            }

            sb.append(String.format("%.1f", (double)sum / 4.0)).append(" ");
            
        }
        
        sb.append("\n");
        int totalSum = 0;

        for(int i = 0; i < 4; ++i) {
            sb.append(String.format("%.1f", (double)(arr[0][i] + arr[1][i]) / 2.0)).append(" ");
            totalSum += (arr[0][i] + arr[1][i]);
        }

        sb.append("\n").append(String.format("%.1f", (double)totalSum / 8.0));

        System.out.println(sb);
    }
}