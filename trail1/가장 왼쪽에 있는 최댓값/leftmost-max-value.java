import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        List<Integer> arr = new ArrayList<>();
        int max = Integer.MIN_VALUE;

        for(int i = 0; i < N; ++i) {
            int a = Integer.parseInt(st.nextToken());
            arr.add(a);
            if(max < a) max = a;
        }
        
        int maxIdx = arr.indexOf(max) + 1;
        sb.append(maxIdx).append(" ");

        while(true) {
            if(maxIdx == 1) break;

            max = Integer.MIN_VALUE;

            for(int i = 0; i < maxIdx - 1; ++i) {
                int a = arr.get(i);
                if(max < a) max = a;
            }

            maxIdx = arr.indexOf(max) + 1;
            sb.append(maxIdx).append(" ");
        }

        System.out.println(sb);
    }
}