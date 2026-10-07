import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        // Please write your code here.
        System.out.println(gcb(n, m));
        
    }

    public static int gcb(int a, int b) {
        if(b == 0) {
            return a;
        }

        return gcb(b, a % b);
    }
}