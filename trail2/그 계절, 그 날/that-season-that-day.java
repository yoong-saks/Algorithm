import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int y = sc.nextInt();
        int m = sc.nextInt();
        int d = sc.nextInt();
        // Please write your code here.
        if(isCorrectYear(y, m, d)) {
            printSeason(m);
        } else {
            System.out.println(-1);
        }
    }

    public static void printSeason(int m) {
        if(3 <= m && m <= 5) {
            System.out.println("Spring");
            return;
        }
        if(6 <= m && m <= 8) {
            System.out.println("Summer");
            return;
        }
        if(9 <= m && m <= 11) {
            System.out.println("Fall");
            return;
        }

        System.out.println("Winter");
    }

    public static boolean isLeapYear(int y) {
        if(y % 4 == 0) {
            if(y % 100 == 0 && y % 400 == 0) return true;
            if(y % 100 == 0) return false;

            return true;
        }

        return false;
    }

    public static boolean isCorrectYear(int y, int m, int d) {
        boolean flag = isLeapYear(y);

        if (m == 2) {
            if (flag && d > 29) return false;
            if (!flag && d > 28) return false;
        } else if (m == 4 || m == 6 || m == 9 || m == 11) {
            if (d > 30) return false;
        } else if (m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12) {
            if (d > 31) return false;
        } 
        return true;
    }
}