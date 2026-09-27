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
    
        while (s1.indexOf(s2) != -1) {
            s1 = s1.substring(0, s1.indexOf(s2)) + s1.substring(s1.indexOf(s2) + s2.length());
        }

        System.out.println(s1);
    }
}