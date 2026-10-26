import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // Please write your code here.
        System.out.println(intactNum(a, b));
    }

    public static int intactNum(int a, int b) {
        int cnt = 0;
        for(int i = a; i <= b; ++i) {
            if(!(i % 2 == 0 || i % 5 == 0 || (i % 3 == 0 && i % 9 != 0))) {
                cnt++;
            }
        }
        return cnt;
    }
}