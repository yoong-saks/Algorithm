import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());

        List<Integer> arr = new ArrayList<>();
        while(true) {
            if(!st.hasMoreTokens()) break;
            int n = Integer.parseInt(st.nextToken());
            if(n == 0) break;
            arr.add(n);
        }

        for(int i = arr.size() - 1; i >= 0; i--) {
            sb.append(arr.get(i)).append(" ");
        }

        System.out.println(sb);
    }
}