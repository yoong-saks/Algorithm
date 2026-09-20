import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String s = br.readLine();
        String s2 = br.readLine();

        if((s + s2).equals(s2 + s)) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}