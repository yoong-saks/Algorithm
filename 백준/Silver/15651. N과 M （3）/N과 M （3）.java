import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder("");

        dfs(0, new int[M]);
        System.out.println(sb);
    }

    private static void dfs(int level, int[] arr) {
        if(level == M) {
            for(int i = 0; i < arr.length; ++i) {
                sb.append(arr[i]);
                sb.append(" ");
            }
            sb.append("\n");

            return;
        }

        for(int i = 1; i <= N; ++i) {
            arr[level] = i;
            dfs(level + 1, arr);
        }
    }
}
