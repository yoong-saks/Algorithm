import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
    private static int[] command1 = new int[100];
    private static int[] command2 = new int[100];
    private static BC[] bcInfo;

    private static int[][] movement = {{0, 0}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private static int A;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1 ; t <= T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken()); // 총 이동 시간 (command 수) (20 <= M <= 100)
            A = Integer.parseInt(st.nextToken()); // BC의 개수 (1<= A <= 8)

            bcInfo = new BC[A];

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; ++i) {
                command1[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < M; ++i) {
                command2[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < A; ++i) {
                st = new StringTokenizer(br.readLine());

                int y = Integer.parseInt(st.nextToken()) - 1;
                int x = Integer.parseInt(st.nextToken()) - 1;
                int c = Integer.parseInt(st.nextToken());
                int p = Integer.parseInt(st.nextToken());

                bcInfo[i] = new BC(x, y, c, p);
            }

            Arrays.sort(bcInfo, (a, b) -> Integer.compare(b.p, a.p));

            int ans = 0;

            int[] p1 = {0, 0};
            int[] p2 = {9, 9};
            ans += bestChoice(p1, p2);
            // 매 시간마다 최선의 선택을 하면 충전한 양의 합이 최대값
            for(int time = 0; time < M; ++time) {
                p1[0] += movement[command1[time]][0];
                p1[1] += movement[command1[time]][1];
                p2[0] += movement[command2[time]][0];
                p2[1] += movement[command2[time]][1];

                ans += bestChoice(p1, p2);
            }

            System.out.println("#" + t + " " + ans);
        }
    }

    private static int bestChoice(int[] p1, int[] p2) {
        int p1Status = 0;
        int p2Status = 0;
        for(int i = 0; i < A; ++i) {
            if(Math.abs(bcInfo[i].x - p1[0]) + Math.abs(bcInfo[i].y - p1[1]) <= bcInfo[i].c) {
                p1Status |= (1 << i);
            }
            if(Math.abs(bcInfo[i].x - p2[0]) + Math.abs(bcInfo[i].y - p2[1]) <= bcInfo[i].c) {
                p2Status |= (1 << i);
            }
        } // 모든 겹치는 케이스를 찾은 후에, 둘이 같은 비콘 하나만 겹치면, 나눠서 충전, 그게 아니라면 조합 중에 가장 큰 값으로
        if(Integer.bitCount(p1Status) == 1 && p1Status == p2Status) {
            int idx = Integer.numberOfTrailingZeros(p1Status);

            return bcInfo[idx].p;
        }
        
        int maxTotal = 0;

        for(int i = 0; i < A; ++i) {
            for(int j = 0; j < A; ++j) {
                int currentSum = 0;
                int p1Power = 0;
                int p2Power = 0;

                if((p1Status & (1 << i)) != 0) p1Power = bcInfo[i].p;
                if((p2Status & (1 << j)) != 0) p2Power = bcInfo[j].p;
                if (i == j && (p1Status & (1 << i)) != 0 && (p2Status & (1 << j)) != 0) {
                    currentSum = p1Power; 
                } else {
                    currentSum = p1Power + p2Power;
                }

                maxTotal = Math.max(maxTotal, currentSum);
            }
        }

        
        return maxTotal;
    }

    private static class BC {
        int x;
        int y;
        int c;
        int p;

        BC(int x, int y, int c, int p) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.p = p;
        }
    }
}