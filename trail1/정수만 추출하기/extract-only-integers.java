import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        String s1 = st.nextToken();
        String s2 = st.nextToken();
        int idx1 = -1;
        int idx2 = -1;

        for(int i = 0; i < s1.length(); ++i) {
            if(!(s1.charAt(i) >= '0' && s1.charAt(i) <= '9')) {
                idx1 = i;
                break;
            }
        }

        for(int i = 0; i < s2.length(); ++i) {
            if(!(s2.charAt(i) >= '0' && s2.charAt(i) <= '9')) {
                idx2 = i;
                break;
            }
        }

        int n1 = 0;
        int n2 = 0;

        if(idx1 != -1) {
            n1 = Integer.parseInt(s1.substring(0, idx1));
        } else {
            n1 = Integer.parseInt(s1);
        }

        if(idx2 != -1) {
            n2 = Integer.parseInt(s2.substring(0, idx2));
        } else {
            n2 = Integer.parseInt(s2);
        }
        sb.append(n1 + n2);

        System.out.println(sb);

    }
}