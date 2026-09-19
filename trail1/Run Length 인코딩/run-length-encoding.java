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
        StringBuilder sb2 = new StringBuilder();

        char c = s.charAt(0);
        int cnt = 1;

        for(int i = 1; i < s.length(); ++i) {
            if(c != s.charAt(i)) {
                sb2.append(c).append(cnt);
                cnt = 1;
            } else {
                cnt++;
            }

            c = s.charAt(i);
        }
        sb2.append(c).append(cnt);
        
        sb.append(sb2.toString().length()).append("\n").append(sb2.toString());
        System.out.println(sb);
        
    }
}