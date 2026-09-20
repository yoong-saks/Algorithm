import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();
        
        for(int i = s.length() - 1; i >= 0; --i) {
            if(i % 2 != 0) {
                sb.append(s.charAt(i));
            }
        }

        System.out.println(sb);
    }
}