import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        // ========================================= //
        int N = Integer.parseInt(br.readLine());

        for(int i = 2; i <= N; ++i) {
            if(isPrime(i)) sb.append(i).append(" ");
        }

        // ========================================= //
        System.out.println(sb);
    }

    private static boolean isPrime(int n) {
        for(int i = 2; i * i <= n; ++i) {
            if(n % i == 0) return false;
        }

        return true;
    }
}