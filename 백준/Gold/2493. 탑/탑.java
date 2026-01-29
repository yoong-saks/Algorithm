import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static class Tower {
        int idx;
        int height;
        
        Tower(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
    
    public static void main(String[] args) throws Exception {        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        Deque<Tower> deq = new ArrayDeque<>();
        
        int N = Integer.parseInt(bf.readLine());
        
        int[] arr = new int[N];
        
        st = new StringTokenizer(bf.readLine());
        
        for(int i = 0; i < N; ++i) {
            int height = Integer.parseInt(st.nextToken());
            
            if(deq.isEmpty()) {
                arr[i] = 0;
                
                deq.add(new Tower(i + 1, height));
                continue;
            }

            while(deq.getLast().height <= height) {
                deq.removeLast();
                if(deq.isEmpty()) break;
            }

            arr[i] = deq.isEmpty() ? 0 : deq.getLast().idx;
            deq.add(new Tower(i + 1, height));
        }

        for(int i = 0; i < N; ++i) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

}
