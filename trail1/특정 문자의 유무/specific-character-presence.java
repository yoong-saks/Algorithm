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

        if(s.contains("ee")) {
            sb.append("Yes").append(" ");
        } else {
            sb.append("No").append(" ");
        }

        if(s.contains("ab")) {
            sb.append("Yes");
        } else {
            sb.append("No");
        }

        System.out.println(sb);
    }
}