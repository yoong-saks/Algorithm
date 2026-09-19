import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String[] arr= new String[N];

        for(int i = 0; i < N; ++i) {
            arr[i] = br.readLine();
        }

        char c = br.readLine().charAt(0);

        int cnt = 0;
        int sum = 0;
        for(int i = 0; i < N; ++i) {
            if(arr[i].charAt(0) == c) {
                cnt++;
                sum += arr[i].length();
            }
        }

        sb.append(cnt).append(" ").append(String.format("%.2f", (double)sum / (double)cnt));

        System.out.println(sb);
    }
}