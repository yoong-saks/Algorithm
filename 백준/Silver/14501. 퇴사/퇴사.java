import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static boolean[] isImpossible;
    private static TP[] timeTable;
    private static int N;
    private static int ans;

    private static class TP {
        int t;
        int p;

        TP(int t, int p) {
            this.t = t;
            this.p = p;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        
        isImpossible = new boolean[N];
        timeTable = new TP[N];

        for(int i = 0; i < N; ++i) {
            st = new StringTokenizer(br.readLine());
            
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            timeTable[i]= new TP(t, p);
            
            if(!(i + t <= N)) {
                isImpossible[i] = true;
            }
        }

        ans = 0;
        dfs(0, 0);
        
        System.out.println(ans);
    }

    private static void dfs(int level, int sum) {
        if(level == N) {
            ans = Math.max(ans, sum);
            return;
        }

        dfs(level + 1, sum);
        if(!isImpossible[level]) {
            boolean[] tmp = new boolean[timeTable[level].t];
            for(int i = 0; i < tmp.length; ++i) {
                tmp[i] = isImpossible[level + i];
                isImpossible[level + i] = true;
            }

            dfs(level + 1, sum + timeTable[level].p);
            
            for(int i = 0; i < tmp.length; ++i) {
                isImpossible[level + i] = tmp[i];
            }
        }
    }
}
