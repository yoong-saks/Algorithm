import java.util.Scanner;

public class Main {
    static int N;
    static int[] primeNum = {1, 2, 3, 5, 7, 9};
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        dfs(0, new StringBuilder(""));
    }

    static void dfs(int level, StringBuilder s) {
        if(level == N) {
            if(isPrime(Integer.parseInt(s.toString()))) {
                System.out.println(s);
            }                
            return;
        }

        for(int i = 0; i < primeNum.length; ++i) {
            if(level == 0 && (i == 0 || i == 6)) {
                continue;
            }

            if(isPrime(Integer.parseInt(s.toString() + primeNum[i]))) {
                dfs(level + 1, s.append(primeNum[i]));
                s.deleteCharAt(s.length() - 1);
            }
        }
    }

    static boolean isPrime(int number) {
        if(number < 2) return false;
        if(number == 2) return true;
        if(number % 2 == 0) return false;
        
        for(int i = 3; i <= (int)Math.sqrt(number); i += 2) {
            if(number % i == 0) return false;
        }

        return true;
    }
}
