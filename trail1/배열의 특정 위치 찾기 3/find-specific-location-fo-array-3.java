import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int[] arr = new int[100];
        int sum = 0;

        for(int i = 0; i < 100; ++i) {
            int n = Integer.parseInt(st.nextToken());
            arr[i] = n;

            if(n == 0) {
                sum += (arr[i - 1] + arr[i - 2] + arr[i - 3]);
                break;
            }    
        }
        
        sb.append(sum);
        System.out.println(sb);
    }
}