import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        printSent(n);

    }

    public static void printSent(int n) {
        for(int i = 0; i < n; ++i) {
            System.out.println("12345^&*()_");
        }
    }
}