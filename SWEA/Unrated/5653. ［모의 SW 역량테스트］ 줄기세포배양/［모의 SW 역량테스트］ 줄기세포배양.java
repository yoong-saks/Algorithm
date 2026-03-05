import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {
	private static int[][] dirdections = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			int ans = 0;
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			Set<Long> crd = new HashSet<>();
			Queue<Cell> q = new ArrayDeque<>();
			
			PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> b.hp - a.hp);
			
			for(int i = 0; i < N; ++i) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < M; ++j) {
					int num = Integer.parseInt(st.nextToken());
					
					if(num != 0) {
						long r = (long)i << 32;
						long result = r | (j & 0xFFFFFFFFL);
						
						crd.add(result);
						pq.add(new Cell(i, j, num));
					}
				}
			}
			
			int time = 0;
			
			while(K > time) {
				int size = pq.size();
				
				while(size-- > 0) {
					Cell cur = pq.poll();
					
					if(cur.offTime > 0) {
						cur.offTime--;
						q.offer(cur);
						continue;
					}
					
					if(cur.onTime == cur.hp) {
						for(int d = 0; d < 4; ++d) {
							int ni = cur.i + dirdections[d][0];
							int nj = cur.j + dirdections[d][1];
							
							long result = ((long)ni << 32 | (nj & 0xFFFFFFFFL));
							
							if(crd.contains(result)) continue;
							
							q.offer(new Cell(ni, nj, cur.hp));
							crd.add(result);
						}
					}

					
					if(--cur.onTime > 0) {
						q.offer(cur);
					}
				}
				
				while(!q.isEmpty()) {
					pq.offer(q.poll());
				}
				time++;
			}
			
			ans = pq.size();
			
			sb.append("#").append(t).append(" ").append(ans).append("\n");
		}
		System.out.println(sb);
	}
	
	private static class Cell {
		int i;
		int j;
		int hp;
		int offTime;
		int onTime;
		
		Cell(int i, int j, int hp) {
			this.i = i;
			this.j = j;
			this.hp = hp;
			this.offTime = hp;
			this.onTime = hp;
		}
	}
}
