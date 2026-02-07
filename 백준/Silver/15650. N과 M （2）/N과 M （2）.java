import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        visited = new boolean[N + 1];

        dfs(0, new int[M], 1);
    }

    private static void dfs(int level, int[] arr, int bottom) {
        if(level == M) {
            for(int i = 0; i < arr.length; ++i) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();

            return;
        }

        for(int i = bottom; i <= N; ++i) {
            if(visited[i]) continue;

            visited[i] = true;
            arr[level] = i;
            dfs(level + 1, arr, i);
            visited[i] = false;
        }
    }
}
