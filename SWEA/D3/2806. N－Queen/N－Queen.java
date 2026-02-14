import java.util.Scanner;

public class Solution {
    private static boolean[] col, diag, rdiag;
    private static int N, ans;
    // NQueen
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int t = 1; t <= T; ++t) {
            N = sc.nextInt();

            col = new boolean[N];
            diag = new boolean[2 * N - 1];
            rdiag = new boolean[2 * N - 1];
            ans = 0;
            btk(0);

            System.out.println("#" + t + " " + ans);
        }
    }

    private static void btk(int cnt) {
        if(cnt == N) {
            ans++;
        }

        for(int i = 0; i < N; ++i) {
            if(col[i]) continue;
            if(diag[i + cnt]) continue;
            if(rdiag[N + cnt - i - 1]) continue;

            col[i] = diag[i + cnt] = rdiag[N + cnt - i - 1] = true;
            btk(cnt + 1);
            col[i] = diag[i + cnt] = rdiag[N + cnt - i - 1] = false;
        }
    }
}
