import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        char[] charArr = br.readLine().toCharArray();

        char tmp = charArr[0];
        char tmp2 = charArr[1];

        for(int i = 0; i < charArr.length; ++i) {
            if(charArr[i] == tmp) {
                charArr[i] = tmp2;
            }
            else if(charArr[i] == tmp2) {
                charArr[i] = tmp;
            }
        }
        
        sb.append(String.valueOf(charArr));

        System.out.println(sb);
    }
}