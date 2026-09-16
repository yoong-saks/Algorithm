import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        String s = br.readLine();

        if(s.equals("L")) sb.append(0);
        else if(s.equals("E")) sb.append(1);
        else if(s.equals("B")) sb.append(2);
        else if(s.equals("R")) sb.append(3);
        else if(s.equals("O")) sb.append(4);
        else if(s.equals("S")) sb.append(5);
        else sb.append("None");
        
        System.out.println(sb);
    }
}