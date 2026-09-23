import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        char[] arr = br.readLine().toCharArray();

        char tmp = arr[0];
        char tmp2 = arr[1];

        for(int i = 0; i < arr.length; ++i) {
            if(arr[i] == tmp2) {
                arr[i] = tmp;
            }
        }

        System.out.println(String.valueOf(arr));
    }
}