import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; ++i) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 0; i < Q; ++i) {
            st = new StringTokenizer(br.readLine());

            int code = Integer.parseInt(st.nextToken());

            if(code == 1) {
                sb.append(arr[Integer.parseInt(st.nextToken()) - 1]).append("\n");
            } else if(code == 2) {
                int n = Integer.parseInt(st.nextToken());
                for(int j = 0; j < arr.length; ++j) {
                    if(arr[j] == n) {
                        sb.append(j + 1).append("\n");
                        break;
                    }
                    if(j == arr.length - 1 && arr[j] != n) {
                        sb.append(0).append("\n");
                    }
                }
            } else {
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;

                for(int j = a; j <= b; ++j) {
                    sb.append(arr[j]).append(" ");
                }
                sb.append("\n");
            }
        }
        
        System.out.println(sb);
    }
}