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
        boolean flag = true;
        int cnt = 1;

        for(int i = N - 1; i >= 0; --i) {
            
            if(flag) {
                for(int j = N - 1; j >= 0; --j) {
                    matrix[j][i] = cnt++;
                    flag = false;
                }
            } else {
                for(int j = 0; j < N; ++j) {
                    matrix[j][i] = cnt++;
                    flag = true;
                }
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