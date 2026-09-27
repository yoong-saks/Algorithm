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
        String command = br.readLine();

        int start = 0;

        for(int i = 0; i < command.length(); ++i) {
            char c = command.charAt(i);

            if(c == 'L') {
                start = (start + 1) % s.length();
            }
            if(c == 'R') {
                start = (start - 1 + s.length()) % s.length();
            }
        }

        for(int i = 0; i < s.length(); ++i) {
            sb.append(s.charAt((start + i) % s.length()));
        }
        
        System.out.println(sb);
    }
}