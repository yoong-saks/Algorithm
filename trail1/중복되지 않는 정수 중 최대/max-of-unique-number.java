import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        int ans = -1;
        for (int i = N - 1; i >= 0; --i) {
            boolean isUnique = true;

            if (i < N - 1 && arr[i] == arr[i + 1]) isUnique = false;
            if (i > 0 && arr[i] == arr[i - 1]) isUnique = false;

            if (isUnique) {
                ans = arr[i];
                break;
            }
        }

        System.out.println(ans);
    }
}