import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int cnt = 1;
        int flag = 0;

        while(true) {
            if((N * cnt) % 5 == 0) {
                flag++;
            }
            sb.append(N * cnt++).append(" ");
            

            if(flag == 2) break;
        }

        System.out.println(sb);
    }
}