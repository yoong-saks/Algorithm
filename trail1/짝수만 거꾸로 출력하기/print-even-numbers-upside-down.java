import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; ++i) {
            int n = Integer.parseInt(st.nextToken());

            if(n % 2 == 0) {
                arr.add(n);
            }
        }

        for(int i = arr.size() - 1; i >= 0; --i) {
            sb.append(arr.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}