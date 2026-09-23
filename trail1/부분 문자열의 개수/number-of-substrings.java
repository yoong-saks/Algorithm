import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s1 = br.readLine();
        String s2 = br.readLine();
        int cnt = 0;

        for(int i = 0; i < s1.length(); ++i) {
            int a = s1.indexOf(s2, i);
            
            if(a != -1) {
                cnt++;
                i = a;
            } else {
                break;
            }
        }

        System.out.println(cnt);
    }
}