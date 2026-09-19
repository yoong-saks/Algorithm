import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String[] arr = new String[10];

        for(int i = 0; i < 10; ++i) {
            arr[i] = br.readLine();
        }

        char c = br.readLine().charAt(0);
        int cnt = 0;

        for(int i = 0; i < 10; ++i) {
            if(arr[i].charAt(arr[i].length() - 1) == c) {
                sb.append(arr[i]).append("\n");
                cnt++;
            }
        }

        if(cnt == 0) sb.append("None");
        System.out.println(sb);
    }
}