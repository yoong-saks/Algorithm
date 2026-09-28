import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int cnt = 1;

        while(true) {
            String s = br.readLine();

            if(s.equals("0")) break;

            if(cnt % 2 == 1) {
                sb.append(s).append("\n");
                
            }
            cnt++;
        }

        StringBuilder sb2 = new StringBuilder();
        sb2.append(cnt - 1).append("\n").append(sb.toString());
        System.out.println(sb2);
    }
}