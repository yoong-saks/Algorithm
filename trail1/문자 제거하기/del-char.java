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

        while(s.length() != 1) {
            int i = Integer.parseInt(br.readLine());

            if(i < s.length()) {
                s = s.substring(0, i) + s.substring(i + 1);
            } else {
                s = s.substring(0, s.length() - 1);
            }
            

            sb.append(s).append("\n");
        }

        System.out.println(sb);
    }
}