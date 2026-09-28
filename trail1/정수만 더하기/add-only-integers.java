import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int ans = 0;

        for(int i = 0; i < s.length(); ++i) {
            if(s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                ans += (int)(s.charAt(i) - '0');
            }
        }

        sb.append(ans);

        System.out.println(ans);

    }
}