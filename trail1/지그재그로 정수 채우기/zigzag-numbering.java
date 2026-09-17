import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][M];
        int cnt = 0;

        for(int j = 0; j < M; ++j) {
            if(j % 2 == 0) {
                for(int i = 0; i < N; ++i) {
                    matrix[i][j] = cnt++;
                }
            } else {
                for(int i = N - 1; i >= 0; --i) {
                    matrix[i][j] = cnt++;
                }
            }
        }

        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < M; ++j) {
                sb.append(matrix[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}