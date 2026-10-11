import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        // Please write your code here.
        int cnt = 0;

        for(int i = A; i <= B; ++i) {
            if(tsn(i)) cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean tsn(int n) {
        return (n % 3 == 0) || containtsn(n);
    }

    public static boolean containtsn(int n) {
        while(n > 0) {
            int tmp = n % 10;
            if(tmp == 3 || tmp == 6 || tmp == 9) return true;
            n /= 10;
        }

        return false;
    }
}