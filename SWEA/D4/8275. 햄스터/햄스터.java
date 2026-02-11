import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static StringBuilder sb;
    private static LRS[] diary;
    private static int[] cage;
    private static int N, X, M, maxHamster;
    
    //사전순으로 가장 앞선 것을 출력..
    //N은 6이므로 그냥 부분집합인가 이거 뒤에서부터 543210 그다음 깊이에서 543210넣고,,
    //마지막 인덱스까지 도달하면 맞는지 검증
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int T = Integer.parseInt(br.readLine());
        
        for(int t = 1; t <= T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            
            N = Integer.parseInt(st.nextToken()); // 햄스터 우리 수
            X = Integer.parseInt(st.nextToken()); // 각 우리마다 들어갈 수 있는 최대 햄스터 수
            M = Integer.parseInt(st.nextToken()); // 햄스터 기록 수
            
            diary = new LRS[M];
            cage = new int[N];
            maxHamster = -1;
            
            for(int i = 0; i < M; ++i) {
                st = new StringTokenizer(br.readLine());
                
                int l = Integer.parseInt(st.nextToken());
                int r = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());
                
                diary[i] = new LRS(l, r, s);
            }

            System.out.print("#" + t);
            dfs(0, 0);

            if(maxHamster == -1) {
                System.out.println(" " + -1);

                continue;
            }

            System.out.println(sb);
            
            
        }
    }
    
    private static void dfs(int cnt, int total) {
        if(cnt == N) {
            for(int i = 0; i < M; ++i) {
                int l = diary[i].l;
                int r = diary[i].r;
                int s = diary[i].s;
                
                int sum = 0;
                
                for(int j = l - 1; j < r; ++j) {
                    sum += cage[j];
                }
                
                if(sum != s) return;
            }

            if(total > maxHamster) {
                maxHamster = total;

                sb = new StringBuilder();
                for(int i = 0; i < N; ++i) {
                    sb.append(" " + cage[i]);
                }
            }

            return;
        }
        
        for(int i = 0; i <= X; ++i) {
            cage[cnt] = i;
            dfs(cnt + 1, total + cage[cnt]);
        }
    }
    
    private static class LRS {
        int l;
        int r;
        int s;
        
        LRS(int l, int r, int s) {
            this.l = l;
            this.r = r;
            this.s = s;
        }
    }
}