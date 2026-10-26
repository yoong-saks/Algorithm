import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        char o = sc.next().charAt(0);
        int c = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        // Please write your code here.

        if(o == '+') {
            sb.append(a).append(" + ").append(c).append(" = ").append(a + c);
        }
        else if(o == '-') {
            sb.append(a).append(" - ").append(c).append(" = ").append(a - c);
        }
        else if(o == '*') {
            sb.append(a).append(" * ").append(c).append(" = ").append(a * c);
        }
        else if(o == '/') {
            sb.append(a).append(" / ").append(c).append(" = ").append(a / c);
        }
        else {
            sb.append("False");
        }

        System.out.println(sb);
    }
}