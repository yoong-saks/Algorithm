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

        
        for(int i = 0; i < N; ++i) {
            arr.add(Integer.parseInt(st.nextToken()));
        }

        arr.sort(Comparator.reverseOrder());

        sb.append(arr.get(0)).append(" ").append(arr.get(1));
        System.out.println(sb);
    }
}