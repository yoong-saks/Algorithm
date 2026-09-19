import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        char c = br.readLine().charAt(0);
        int cnt = 0;
        String[] fruits = new String[]{"apple", "banana", "grape", "blueberry", "orange"};

        for(int i = 0; i < fruits.length; ++i) {
            if(fruits[i].charAt(2) == c || fruits[i].charAt(3) == c) {
                sb.append(fruits[i]).append("\n");
                cnt++;
            }
        }

        sb.append(cnt);

        System.out.println(sb);
    }
}