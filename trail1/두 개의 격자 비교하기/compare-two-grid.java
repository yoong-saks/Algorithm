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

        for(int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; ++j) {
                int a = Integer.parseInt(st.nextToken());
                matrix[i][j] = a;
            }
        }

        for(int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < M; ++j) {
                int a = Integer.parseInt(st.nextToken());

                if(matrix[i][j] == a) sb.append(0).append(" ");
                else sb.append(1).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
        
    }
}