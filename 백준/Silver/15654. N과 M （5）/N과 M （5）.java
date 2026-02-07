import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static int N;
    private static int M;
    private static int[] Narr;
    private static boolean[] visited;
    private static StringBuilder sb;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        sb = new StringBuilder("");
        st = new StringTokenizer(br.readLine());

        Narr = new int[N];
        visited = new boolean[N];

        for(int i = 0; i < N; ++i) {
            Narr[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(Narr);

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

        for(int i = 0; i < N; ++i) {
            if(visited[i]) continue;

            visited[i] = true;

            arr[level] = Narr[i];
            dfs(level + 1, arr);
            
            visited[i] = false;
        }
    }
}
