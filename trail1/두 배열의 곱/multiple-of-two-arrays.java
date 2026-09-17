import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int[][] matrix = new int[3][3];

        for(int i = 0; i < 3; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; ++j) {
                int a = Integer.parseInt(st.nextToken());
                matrix[i][j] = a;
            }
        }
        br.readLine();
        
        for(int i = 0; i < 3; ++i) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 3; ++j) {
                int a = Integer.parseInt(st.nextToken());
                matrix[i][j] *= a;

                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}