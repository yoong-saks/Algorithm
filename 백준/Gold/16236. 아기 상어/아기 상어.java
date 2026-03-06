import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	private static int[][] map = new int[20][20];
	private static int[][] directions = { {-1, 0}, {0, 1}, {1, 0}, {0, -1} };
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int ci = 0;
		int cj = 0;
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				map[i][j] = Integer.parseInt(st.nextToken());
				
				if(map[i][j] == 9) {
					map[i][j] = 0;
					
					ci = i;
					cj = j;
				}
			}
		}
		
		int cSize = 2;
		int cEat = 0;
		int time = 0;
		
		while(true) {
			PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
				if (a.d != b.d) return a.d - b.d; //1순위 최소 거리
				if (a.i != b.i) return a.i - b.i; //2순위 가장 위
				return a.j - b.j; //3순위 가장 왼쪽
			}
			);
			
			boolean[][] visited = new boolean[N][N];
			
			pq.offer(new Node(ci, cj, 0));
			visited[ci][cj] = true;
			
			boolean flag = false;
			
			while(!pq.isEmpty()) {
				Node cur = pq.poll();
				
				//1. 먹을 수 있는 물고기를 발견한 경우
				if(map[cur.i][cur.j] > 0 && map[cur.i][cur.j] < cSize) {
					map[cur.i][cur.j] = 0;
					cEat++;
					
					if(cEat == cSize) {
						cSize++;
						cEat = 0;
					}
					
					time += cur.d;
					ci = cur.i;
					cj = cur.j;
					
					flag = true;
					break;
				}
				
				for(int d = 0; d < 4; ++d) {
					int ni = cur.i + directions[d][0];
					int nj = cur.j + directions[d][1];
					
					if(!(0 <= ni && ni < N) || !(0 <= nj && nj < N)) continue;
					if(visited[ni][nj]) continue;
					if(map[ni][nj] > cSize) continue;
				
					visited[ni][nj] = true;
					pq.offer(new Node(ni, nj, cur.d + 1));
				}
			}
			
			if(!flag) {
				break;
			}
		}
		System.out.println(time);
	}
	
	private static class Node {
		int i;
		int j;
		int d;
		
		Node(int i, int j, int d) {
			this.i = i;
			this.j = j;
			this.d = d;
		}
	}

}
