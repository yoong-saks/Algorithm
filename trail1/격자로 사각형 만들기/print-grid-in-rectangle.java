import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];

        for(int i = 0; i < N; ++i) {
            matrix[i][0] = 1;
            matrix[0][i] = 1;
        }

        for(int i = 1; i < N; ++i) {
            for(int j = 1; j < N; ++j) {
                matrix[i][j] = matrix[i - 1][j] + matrix[i][j - 1] + matrix[i - 1][j - 1];
            }
        }

        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < N; ++j) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}