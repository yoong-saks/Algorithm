import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.
        int cnt = 0;

        for(int i = a; i <= b; ++i) {
            if(isPrimeNum(i) && isEvenSum(i)) cnt++;
        }

        System.out.println(cnt);
    }

    public static boolean isPrimeNum(int n) {
        for(int i = 2; i * i <= n; ++i) {
            if(n % i == 0) return false;
        }

        return true;
    }

    public static boolean isEvenSum(int n) {
        int sum = 0;
        while(n != 0) {
            sum += n % 10;
            n /= 10;
        }

        return sum % 2 == 0;
    }
}