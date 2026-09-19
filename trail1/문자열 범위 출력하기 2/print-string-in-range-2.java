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
        int n = Integer.parseInt(br.readLine());

        for(int i = s.length() - 1; i >= s.length() - n; --i) {
            sb.append(s.charAt(i));
            if(i == 0) break;
        }

        System.out.println(sb);

    }
}