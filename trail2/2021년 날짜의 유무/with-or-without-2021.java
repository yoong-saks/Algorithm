import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int d = sc.nextInt();
        // Please write your code here.
        if(correct21year(m, d)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }

    public static boolean correct21year(int m, int d) {
        if(m > 12) return false;

        if(m == 2) {
            if(d > 28) return false;
        }

        if(m < 8) {
            if(m % 2 == 0) {
                if(d > 30) return false;
            }
            else {
                if(d > 31) return false;
            }
        }
        else {
            if(m % 2 == 0) {
                if(d > 31) return false;
            }
            else {
                if(d > 30) return false;
            }
        }
        return true;
    }
}