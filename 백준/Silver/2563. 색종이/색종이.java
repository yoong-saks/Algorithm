import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        boolean[][] arr = new boolean[101][101];

        int n = sc.nextInt();
        sc.nextLine();

        int ans = 0;

        for(int i = 0; i < n; ++i) {
            int x = sc.nextInt();
            int y = sc.nextInt();

            for(int r = 0; r < 10; ++r) {
                for(int c = 0; c < 10; ++c) {
                    if(!(x + r <= 100) || !(y + c <= 100) || arr[x + r][y + c]) {
                        continue;
                    }
                    
                    arr[x + r][y + c] = true;
                    ans++;
                }
            }

        }

        System.out.println(ans);
    }
}
