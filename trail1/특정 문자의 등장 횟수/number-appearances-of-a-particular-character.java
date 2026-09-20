import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        int cnt1 = 0;
        int cnt2 = 0;
        for(int i = 0; i < s.length() - 1; ++i) {
            if(s.charAt(i) == 'e' && s.charAt(i + 1) == 'e') {
                cnt1++;
            }
            if(s.charAt(i) == 'e' && s.charAt(i + 1) == 'b') {
                cnt2++;
            }
        }

        sb.append(cnt1).append(" ").append(cnt2);
        
        System.out.println(sb);
    }
}