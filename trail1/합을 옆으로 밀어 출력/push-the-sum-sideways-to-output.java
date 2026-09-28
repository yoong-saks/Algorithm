import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int m = Integer.parseInt(br.readLine());
        int sum = 0;

        for(int i = 0; i < m; ++i) {
            sum += Integer.parseInt(br.readLine());
        }

        sb.append(Integer.toString(sum));
        char tmp = sb.charAt(0);
        sb.deleteCharAt(0);
        sb.append(tmp);

        System.out.println(sb);
    }
}