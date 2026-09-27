import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        String ans = s.substring(0, s.indexOf("e")) + s.substring(s.indexOf("e") + 1);

        StringBuilder sb = new StringBuilder();

        sb.append(ans);

        System.out.println(sb);
    }
}