import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int ascii = (int)br.readLine().charAt(0);
        
        ascii -= 'a';
        ascii = (ascii - 1 + ('z' - 'a' + 1)) % ('z' - 'a' + 1);
        ascii += 'a';

        sb.append((char)ascii);

        System.out.println(sb);
    }
}