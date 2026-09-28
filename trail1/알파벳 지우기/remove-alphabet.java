import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s1 = br.readLine();
        String s2 = br.readLine();

        StringBuilder sb1 = new StringBuilder();

        for(int i = 0; i < s1.length(); ++i) {
            if(s1.charAt(i) >= '0' && s1.charAt(i) <= '9') {
                sb1.append(s1.charAt(i));
            }
        }

        int ans = Integer.parseInt(sb1.toString());
        sb1.setLength(0);

        for(int i = 0; i < s2.length(); ++i) {
            if(s2.charAt(i) >= '0' && s2.charAt(i) <= '9') {
                sb1.append(s2.charAt(i));
            }
        }

        ans += Integer.parseInt(sb1.toString());

        sb.append(ans);

        System.out.println(sb);

    }
}