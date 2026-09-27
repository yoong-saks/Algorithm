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
        String doubled = s + s;
        
        for(int i = s.length(); i >= 0; --i) {
            sb.append(doubled.substring(i, s.length() + i));
            sb.append("\n");
        }

        System.out.println(sb);
    }
}