import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	private static char[][] map = new char[300][300];
	private static int[][] directions = { {-1, 0}, {-1 , 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1} };

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(br.readLine());
			
			int dotCnt = 0;
			for(int i = 0; i < N; ++i) {
				String s = br.readLine();
				for(int j = 0; j < N; ++j) {
					map[i][j] = s.charAt(j);
					
					if(map[i][j] == '.') dotCnt++;
				}
			}
//			
//			System.out.println(dotCnt);
//			
			
			// 주변에 가장 별이 적은 애들부터 뽑히도록 pq생성
			PriorityQueue<IJ> pq = new PriorityQueue<>((a, b) -> a.starCnt - b.starCnt);
			
			for(int i = 0; i < N; ++i) {
				for(int j = 0; j < N; ++j) {
					int stars = 0;
					if(map[i][j] == '.') {
						for(int d = 0; d < 8; ++d) {
							int ni = i + directions[d][0];
							int nj = j + directions[d][1];
							
							if(!(0 <= ni && ni < N) || !(0 <= nj && nj < N)) continue;
							
							if(map[ni][nj] == '*') stars++;
						}
						
						pq.offer(new IJ(i, j, stars));
					}

				}
			}
			
			int time = 0;
			while(!pq.isEmpty()) {
				IJ startNode = pq.poll();
				
				if(map[startNode.i][startNode.j] != '.') continue;
				
				time++;
				Queue<IJ> q = new ArrayDeque<>();
				q.offer(startNode);
				map[startNode.i][startNode.j] = 'V';
				
//				for(int i = 0; i < N; ++i) {
//					for(int j = 0; j < N; ++j) {
//						if(map[i][j] == '.') {
//							q.add(new IJ(i, j));
//							System.out.println("add : " + i + " " + j);
//							i = N;
//							j = N;
//							continue;
//						}
//					}
//				}
				
				while(!q.isEmpty()) {
					IJ cur = q.poll();
//					System.out.println("poll : " + cur.i + " " + cur.j);
					
					
					ArrayList<IJ> ninjs = new ArrayList<>();
					boolean hasMine = false;
					
					for(int d = 0; d < 8; ++d) {
						int ni = cur.i + directions[d][0];
						int nj = cur.j + directions[d][1];
						
						if(!(0 <= ni && ni < N) || !(0 <= nj && nj < N)) continue;
						
						if(map[ni][nj] == '*') {
							hasMine = true;
						} else if(map[ni][nj] == '.') {
							ninjs.add(new IJ(ni, nj));
						}
					}
					
					if(!hasMine) {
						for(int i = 0; i < ninjs.size(); ++i) {
//							System.out.println(ninjs.get(i).i + " " + ninjs.get(i).j);
//							System.out.println();
//							System.out.println();
							if(map[ninjs.get(i).i][ninjs.get(i).j] == '.') {
								map[ninjs.get(i).i][ninjs.get(i).j] = 'V';
								q.offer(ninjs.get(i));
							}
						}
					}
					
//					for(int i = 0; i < N; ++i) {
//						for(int j = 0; j < N; ++j) {
//							System.out.print(map[i][j]);
//						}
//						System.out.println();
//					}
					
				}
			}
//			for(int i = 0; i < N; ++i) {
//				for(int j = 0; j < N; ++j) {
//					System.out.print(map[i][j]);
//				}
//				System.out.println();
//			}
			sb.append("#").append(t).append(" ").append(time).append("\n");
		}
		
		System.out.println(sb);
	}
	
	private static class IJ {
		int i;
		int j;
		int starCnt;
		
		IJ(int i, int j) {
			this.i = i;
			this.j = j;
		}
		
		IJ(int i, int j, int starCnt) {
			this(i, j);
			this.starCnt = starCnt;
		}
	}
}
