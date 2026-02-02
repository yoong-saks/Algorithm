import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static boolean check(int[] dnaCount, int[] minDnaOrder) {
		for(int i = 0; i < 4; ++i) {
			if(dnaCount[i] < minDnaOrder[i]) return false;
		}
		return true;
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[] dnaCount = new int[4];
		int[] minDnaOrder = new int[4];
		int ans = 0;
		
		st = new StringTokenizer(br.readLine());
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		String dnaOrder = br.readLine();
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < 4; ++i) {
			minDnaOrder[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < P; ++i) {
			char c = dnaOrder.charAt(i);
			
			if(c == 'A') dnaCount[0]++;
			if(c == 'C') dnaCount[1]++;
			if(c == 'G') dnaCount[2]++;
			if(c == 'T') dnaCount[3]++;
		}
		
		if(check(dnaCount, minDnaOrder)) ans++;
		
		for(int i = P; i < S; ++i) {
			char nextC = dnaOrder.charAt(i);
			char prevC = dnaOrder.charAt(i - P);
			
			if(nextC == 'A') dnaCount[0]++;
			if(prevC == 'A') dnaCount[0]--;
			if(nextC == 'C') dnaCount[1]++;
			if(prevC == 'C') dnaCount[1]--;
			if(nextC == 'G') dnaCount[2]++;
			if(prevC == 'G') dnaCount[2]--;
			if(nextC == 'T') dnaCount[3]++;
			if(prevC == 'T') dnaCount[3]--;
			
			if(check(dnaCount, minDnaOrder)) ans++;
		}
		
		System.out.println(ans);
	}
	
}
