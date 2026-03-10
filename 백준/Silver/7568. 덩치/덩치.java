import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		WH[] humans = new WH[N];
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
		
			humans[i] = new WH(a, b);
		}
		
		for(int i = 0; i < N; ++i) {
			for(int j = 0; j < N; ++j) {
				if(i == j) continue;
				
				if(humans[i].weight < humans[j].weight) {
					if(humans[i].height < humans[j].height) {
						humans[i].rank++;
					}
				}
			}
		}
		
		for(int i = 0; i < N; ++i) {
			System.out.print(humans[i].rank + " ");
		}
		System.out.println();
		
	}

	private static class WH {
		int weight;
		int height;
		int rank = 1;
		
		WH(int w, int h) {
			weight = w;
			height = h;
		}
	}
}
