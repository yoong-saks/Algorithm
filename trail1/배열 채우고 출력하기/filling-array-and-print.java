import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        String[] arr = new String[10];
        
        for(int i = 0; i < 10; ++i) {
            arr[i] = st.nextToken();
        }

        for(int i = 9; i >= 0; --i) {
            sb.append(arr[i]);
        }

        System.out.println(sb);
    }
}