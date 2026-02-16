import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 홈 방범 서비스
public class Solution {
    private static int[][] map = new int[20][20];
    private static int N;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken()); // 맵 크기 5 <= N <= 20
            int M = Integer.parseInt(st.nextToken()); // 각 집들이 지불할 수 있는 비용 1 <= M <= 10

            for(int i = 0; i < N; ++i) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; ++j) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int k = 1;
            int houseCnt = 0;
            int ans = 0;    

            while(true) {
                for(int i = 0; i < N; ++i) {
                    for(int j = 0; j < N; ++j) { //완탐. 모든 점에서 K = 1에서부터 맨해튼 거리 구해서 그 때 이익이 가장 큰거
                        houseCnt = calculateHouse(i, j, k); // i, j에서 k거리까지의 집 개수

                        if(houseCnt * M >= (k * k + ((k - 1) * (k - 1)))) {
                            ans = Math.max(ans, houseCnt);
                        }
                    }
                }
                if(k > N * 2) break;

                k++;
            }

            System.out.println("#" + t + " " + ans);
        }
    }

    private static int calculateHouse(int r, int c, int k) {
        int cnt = 0;
        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < N; ++j) {
                if(Math.abs(r - i) + Math.abs(c - j) < k) {
                    if(map[i][j] == 1) cnt++;
                }
            }
        }

        return cnt;
    }
}
