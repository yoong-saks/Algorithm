import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s1 = br.readLine();
        String s2 = br.readLine();
        String s3 = br.readLine();

        if(s1.length() >= s2.length() && s2.length() >= s3.length()) {
            sb.append(s1.length() - s3.length());
        } else if(s1.length() >= s3.length() && s3.length() >= s2.length()) {
            sb.append(s1.length() - s2.length());
        } else if(s2.length() >= s1.length() && s1.length() >= s3.length()) {
            sb.append(s2.length() - s3.length());
        } else if(s2.length() >= s3.length() && s3.length() >= s1.length()) {
            sb.append(s2.length() - s1.length());
        } else if(s3.length() >= s1.length() && s1.length() >= s2.length()) {
            sb.append(s3.length() - s2.length());
        } else {
            sb.append(s3.length() - s1.length());
        }

        System.out.println(sb);
    }
}