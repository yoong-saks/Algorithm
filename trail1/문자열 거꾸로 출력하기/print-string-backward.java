import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true) {
            sb.append(br.readLine());
            if(sb.toString().equals("END")) break;

            System.out.println(sb.reverse());
            sb.setLength(0);
        }
    }
}