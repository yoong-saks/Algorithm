import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char c = br.readLine().charAt(0);
        if(c != 'z') {
            sb.append((char)(c + 1));
        } else {
            sb.append('a');
        }
        

        System.out.println(sb);
    }
}