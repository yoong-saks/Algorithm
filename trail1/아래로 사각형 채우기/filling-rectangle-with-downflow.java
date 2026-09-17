import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[][] matrix = new int[N][N];
        int cnt = 0;

        for(int j = 0; j < N; ++j) {
            for(int i = 0; i < N; ++i) {
                int a = ++cnt;
                matrix[i][j] = a;
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