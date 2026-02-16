import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
    private static int[] ticketPrice = new int[4];
    private static int[] yearPlan = new int[12];
    private static int minPrice;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; ++t) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 4; ++i) {
                ticketPrice[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());

            for(int i = 0; i < 12; ++i) {
                yearPlan[i] = Integer.parseInt(st.nextToken());
            }
            
            minPrice = Integer.MAX_VALUE;

            btk(0, 0);
            
            minPrice = Math.min(ticketPrice[3], minPrice);

            System.out.println("#" + t + " " + minPrice);
        }
    }

    private static void btk(int month, int price) {
        if(minPrice < price) return;
        
        if(month > 11) {
            minPrice = Math.min(price, minPrice);
            return;
        }

        btk(month + 1, price + Math.min(yearPlan[month] * ticketPrice[0], ticketPrice[1]));
        btk(month + 3, price + ticketPrice[2]);
    }
}
