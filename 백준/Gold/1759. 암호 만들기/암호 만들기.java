import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static String[] alphabets;
    private static int pwLength;
    private static int alphaNum;
    private static StringBuilder sb = new StringBuilder();
    
    private static final String VOWEL = "aeiou";

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());

        pwLength = Integer.parseInt(st.nextToken());
        alphaNum = Integer.parseInt(st.nextToken());


        alphabets = br.readLine().split(" ");
        Arrays.sort(alphabets);

        dfs(0, 0, new String[pwLength], 0);
        
        System.out.println(sb);
    }

    private static void dfs(int cnt, int start, String[] pw, int vowelCnt) {
        if(cnt == pwLength) {
            if(vowelCnt >= 1 && (pwLength - vowelCnt) >= 2) {
                for(int i = 0; i < pw.length; ++i) {
                    sb.append(pw[i]);
                }
                sb.append("\n");
            }

            return;
        }   

        for(int i = start; i < alphabets.length; ++i) {
            pw[cnt] = alphabets[i];
            int vwCnt = vowelCnt;
            if(VOWEL.contains(pw[cnt])) {
                vwCnt++;
            }

            dfs(cnt + 1, i + 1, pw, vwCnt);
        }
    }
}
