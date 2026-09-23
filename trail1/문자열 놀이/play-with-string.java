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

        char[] charArr = st.nextToken().toCharArray();
        int q = Integer.parseInt(st.nextToken());

        for(int i = 0; i < q; ++i) {
            st = new StringTokenizer(br.readLine());

            int c = Integer.parseInt(st.nextToken());

            if(c == 1) {
                int n1 = Integer.parseInt(st.nextToken()) - 1;
                int n2 = Integer.parseInt(st.nextToken()) - 1;

                char tmp = charArr[n1];
                charArr[n1] = charArr[n2];
                charArr[n2] = tmp;

                sb.append(String.valueOf(charArr)).append("\n");
            }
            if(c == 2) {
                char c1 = st.nextToken().charAt(0);
                char c2 = st.nextToken().charAt(0);

                for(int j = 0; j < charArr.length; ++j) {
                    if(charArr[j] == c1) {
                        charArr[j] = c2;
                    }
                }
                sb.append(String.valueOf(charArr)).append("\n");
            }

        }
        System.out.println(sb);
    }
}