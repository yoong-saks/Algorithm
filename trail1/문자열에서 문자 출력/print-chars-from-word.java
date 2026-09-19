import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        for(int i = 0; i < s.length(); ++i) {
            sb.append(s.charAt(i)).append("\n");
        }

        System.out.println(sb);
    }
}