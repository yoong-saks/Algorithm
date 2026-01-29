import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		//int T = sc.nextInt();
		
		for(int t = 1; t <= 10; ++t) {
			sc.nextInt();
			
			Deque<Integer> deq = new ArrayDeque<>();
			
			for(int i = 0; i < 8; ++i) {
				deq.add(sc.nextInt());
			}
			
			int first = deq.removeFirst();
			int cnt = 1;
			
			while(true) {
				if(cnt == 6) cnt = 1;
				first -= cnt;
				
				deq.addLast(first);
				
				if((first) <= 0) {
					break;
				}
				
				first = deq.removeFirst();
				cnt++;
			}
			deq.removeLast();
			deq.addLast(0);
			
			System.out.println(cnt);
			System.out.print("#" + t);
			
			for(int i : deq) {
				System.out.print(" " + i);
			}
			System.out.println();
		}
	}

}
