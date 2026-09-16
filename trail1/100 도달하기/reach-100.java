import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        List<Integer> arr = new ArrayList<>();

        arr.add(1);
        sb.append(1).append(" ");
        arr.add(N);
        sb.append(N).append(" ");

        int offset = 2;
        while(true) {
            int val = arr.get(offset - 1) + arr.get(offset - 2);

            arr.add(val);
            sb.append(val).append(" ");
            offset++;
            if(val > 100) break;
        }

        System.out.println(sb);
    }
}