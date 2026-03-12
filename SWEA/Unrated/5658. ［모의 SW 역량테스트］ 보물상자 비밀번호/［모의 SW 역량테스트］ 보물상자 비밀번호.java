import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			Set<Integer> hs = new HashSet<>();
			ArrayList<Integer> arr = new ArrayList<>();
			
			StringBuilder sb2 = new StringBuilder(br.readLine());
			
			
			for(int i = 0; i < (N / 4); ++i) {
				int[] face = new int[4];
				face[0] = Integer.parseInt(sb2.substring(0, (N / 4) * 1), 16);
				face[1] = Integer.parseInt(sb2.substring((N / 4) * 1, (N / 4) * 2), 16);
				face[2] = Integer.parseInt(sb2.substring((N / 4) * 2, (N / 4) * 3), 16);
				face[3] = Integer.parseInt(sb2.substring((N / 4) * 3, (N / 4) * 4), 16);

				for(int j = 0; j < 4; ++j) {
					if(hs.add(face[j])) {
						arr.add(face[j]);
					}
				}
				
				StringBuilder tmp = new StringBuilder(sb2);
				sb2 = new StringBuilder();
				sb2.append(tmp.charAt(tmp.length() - 1));
				sb2.append(tmp.substring(0, tmp.length() - 1));
				
			}
			
			Collections.sort(arr, Comparator.reverseOrder());
			
			sb.append("#").append(t).append(" ").append(arr.get(K - 1)).append("\n");
		}
		System.out.println(sb);
	}

}
