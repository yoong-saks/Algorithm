import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        // Please write your code here.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        char[] charArr = br.readLine().toCharArray();

        charArr[1] = 'a';
        charArr[charArr.length - 2] = 'a';

        System.out.println(String.valueOf(charArr));
    }
}