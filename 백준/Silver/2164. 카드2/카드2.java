import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {

	public static void main(String[] args) throws Exception {
		ArrayDeque<Integer> adq = new ArrayDeque<>();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= N; ++i) {
			adq.add(i);
		}
		while(adq.size() != 1) {
			adq.pollFirst();
			adq.addLast(adq.pollFirst());
		}
		
		System.out.println(adq.poll());
	}

}
