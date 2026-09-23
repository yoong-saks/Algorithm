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

        sb.append(s.substring(0, 1)).append(s.substring(2, s.length() - 2)).append(s.substring(s.length() - 1));

        System.out.println(sb);
    }
}