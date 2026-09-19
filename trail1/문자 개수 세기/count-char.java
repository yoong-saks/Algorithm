import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        char f = br.readLine().charAt(0);
        int cnt = 0;

        for(int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);

            if(c == f) cnt++;
        }

        System.out.println(cnt);
    }
}