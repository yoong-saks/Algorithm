import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // Please write your code here.
        int cnt = 1;
        StringBuilder sb = new StringBuilder();


        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                sb.append(cnt++).append(" ");

                if(cnt == 10) cnt = 1;
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}