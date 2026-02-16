import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int[] trees = new int[100];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; ++t) {
            int N = Integer.parseInt(br.readLine());
            int maxHeight = 0;
            
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; ++i) {
                trees[i] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, trees[i]);
            }

            int one = 0;
            int two = 0;
            int ans = 0;

            for(int i = 0; i < N; ++i) { // 전체 나무의 차이들을 2의개수와 1의 개수로 저장
                if(trees[i] == maxHeight) continue;
                int diff = maxHeight - trees[i];

                one += diff % 2;
                two += diff / 2;
            }
            
            // 2의 개수와 1의 개수가 같은 게 가장 이상적인 상황
            // 2가 1보다 더 많을 때는 2를 1 두개로 나눠짐.
            if(two > one) { // 2의 개수가 1의 개수보다 더 많으면 2 한 개는 1 두 개로 나눌 수 있음
                // two - one의 차가 1이 될 때까지
                while(Math.abs(two - one) > 1) {
                    two -= 1;
                    one += 2;
                }
            }

            while(two != 0 && one != 0) {
                two -= 1;
                one -= 1;

                ans += 2;
            }

            if(two != 0) {
                ans += 2;
            }

            if(one != 0) {
                ans += ((one * 2) - 1);
            }

            System.out.println("#" + t + " " + ans);
        }
    }
}