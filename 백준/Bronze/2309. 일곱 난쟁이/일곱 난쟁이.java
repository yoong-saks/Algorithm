import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        
        int[] arr = new int[9];
        int sum = 0;
        for(int i = 0; i < 9; ++i) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }
        boolean find =false;
        for(int i = 0; i < 9 && !find; ++i) {
            for(int j = i + 1; j < 9 && !find; ++j) {
                if(sum - arr[i] - arr[j] == 100) {
                    arr[i] = 0;
                    arr[j] = 0;
                    find = true;
                }
            }
        }
        
        Arrays.sort(arr);

        for(int i = 2; i < 9; ++i) {
            System.out.println(arr[i]);
        }
    }
}
