import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[10];
        arr[0] = Integer.parseInt(st.nextToken());
        arr[1] = Integer.parseInt(st.nextToken());
        
        for(int i = 2; i < 10; ++i) {
            arr[i] = arr[i - 1] + 2 * arr[i - 2];
        }

        for(int i = 0; i < 10; ++i) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}