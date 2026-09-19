import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int[][] matrix = new int[N][N];

        int M = Integer.parseInt(st.nextToken());
        int cnt = 1;

        for(int i = 0; i < M; ++i) {
            st = new StringTokenizer(br.readLine());

            int y = Integer.parseInt(st.nextToken()) - 1;
            int x = Integer.parseInt(st.nextToken()) - 1;

            matrix[y][x] = cnt++;
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