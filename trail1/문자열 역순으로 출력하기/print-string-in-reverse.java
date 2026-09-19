import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String[] str = new String[4];

        for(int i = 0; i < 4; ++i) {
            str[i] = br.readLine();
        }

        for(int i = 3; i >= 0; --i) {
            sb.append(str[i]).append("\n");
        }

        System.out.println(sb);
    }
}