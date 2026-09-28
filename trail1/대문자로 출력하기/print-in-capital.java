import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        for(int i = 0; i < s.length(); ++i) {
            if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z')) {
                if((s.charAt(i) >= 'a' && s.charAt(i) <= 'z')) {
                    sb.append((char)(s.charAt(i) - 'a' + 'A'));
                } else {
                    sb.append(s.charAt(i));
                }
            }
        }

        System.out.println(sb);
        
    }
}