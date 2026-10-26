import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        int[] a = new int[n1];
        int[] b = new int[n2];
        for (int i = 0; i < n1; i++)
            a[i] = sc.nextInt();
        for (int i = 0; i < n2; i++)
            b[i] = sc.nextInt();
        // Please write your code here.

        if(n2 > n1) {
            System.out.println("No");
            return;
        }
        if(isCorrect(n1, n2, a, b)) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }

    }

    public static boolean isCorrect(int n1, int n2, int[] a, int[] b) {
        for(int i = 0; i <= n1 - n2; ++i) {
            boolean match = true;
            for(int j = 0; j < n2; ++j) {
                if(a[i + j] != b[j]) {
                    match = false;
                    break;
                }
            }
            if(match) return true;
        }

        return false;
    }
}