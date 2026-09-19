import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        List<String> arr = new ArrayList<>();

        while(st.hasMoreTokens()) {
            arr.add(st.nextToken());
        }

        for(int i = arr.size() - 1; i >= 0; --i) {
            sb.append(arr.get(i)).append("\n");
        }
        System.out.println(sb);
    }
}