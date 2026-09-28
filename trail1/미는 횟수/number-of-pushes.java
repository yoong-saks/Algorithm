import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder origin = new StringBuilder();
        origin.append(br.readLine());

        StringBuilder dest = new StringBuilder();
        dest.append(br.readLine());

        int cnt = 0;

        for(int i = 0; i < origin.length(); ++i) {
            if(origin.toString().equals(dest.toString())) {
                System.out.println(cnt);
                return;

            }

            char tmp = origin.charAt(origin.length() - 1);
            origin.deleteCharAt(origin.length() - 1);
            origin.insert(0, tmp);
            cnt++;
        }
        System.out.println(-1);
    }
}