import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

// 1000개가 100의 에너지 방출 -> 100000 int
// -1000 ~ 1000 -> +1000해서 shift
// 맵이 무한이라고 가정하더라도, 모든 원소의 속도가 동일하기에 맵 밖으로 나가게 된 원소가 다른 원소에 부딪힐 일이 없음.
// 그냥 구현 문제
// 모든 객체는 0.5씩 움직이면 중간에서 만난 것도 판단 가능 
// int로 0.5씩 움직임을 나타내기위해 visited 배열은 (2001 + 2000)^2 사이즈 (약 = 1600kb)
// 객체의 위치는 쉬프트된 기준으로 * 2 위치로 받아서 저장. 
// 모든 객체가 없어질 때까지 반복해서 모든 객체들을 움직이게 하고 그 객체의 위치를 visited true를 함.
// 객체들이 만나게 되면 모든 객체가 움직인 후, 에너지 반영
public class Solution {

	private static int[] di = {1, -1, 0, 0}; // y
	private static int[] dj = {0, 0, -1, 1}; // x
	private static boolean[][] visited = new boolean[4001][4001];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			int N = Integer.parseInt(br.readLine());
			
			List<XYDE> list = new ArrayList<>();
			int ans = 0;
			
			for(int i = 0; i < N; ++i) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				int x = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int y = (Integer.parseInt(st.nextToken()) + 1000) * 2;
				int d = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				
				list.add(new XYDE(x, y, d, e));
			}
			
			XYDE[] deleteList = new XYDE[list.size()];
					
			while(!list.isEmpty()) { //모든 리스트가 없어질때까지
				int idx = 0;
				
				for(int i = 0; i < list.size(); ++i) { //모든 리스트를 순회
					XYDE cur = list.get(i);
					
					cur.x += dj[cur.d];
					cur.y += di[cur.d];
					
					visited[cur.y - di[cur.d]][cur.x - dj[cur.d]]= false;
					
					if(!(0 <= cur.x && cur.x < 4001) || !(0 <= cur.y && cur.y < 4001)) {
						cur.e = 0;
						
						cur.x -= dj[cur.d];
						cur.y -= di[cur.d];
						
						deleteList[idx++] = cur;
						
						continue;
					}
					if(visited[cur.y][cur.x]) {
						deleteList[idx++] = cur;
						cur.flag = true;
						
						for(int j = 0; j < i; ++j) {
							if((!list.get(j).flag) &&list.get(j).x == cur.x && list.get(j).y == cur.y) {
								list.get(j).flag = true;
								deleteList[idx++] = list.get(j);
								break;
							}
						}
						
						continue;
					}
					 
					visited[cur.y][cur.x] = true; 
				}
				
//				Iterator<XYDE> iter = list.iterator();
				for(int i = list.size() - 1; i >= 0; --i) {
					XYDE cur = list.get(i);
					
					for(int j = 0; j < idx; ++j) {
						if(cur.equals(deleteList[j])) {
							ans += cur.e;
							list.remove(i);
							visited[cur.y][cur.x] = false; 
							break;
						}
					}
				}
				
//				while(iter.hasNext()) {
//					XYDE cur = iter.next();
//					
//					for(int i = 0; i < idx; ++i) {
//						if(cur.equals(deleteList[i])) {
//							ans += cur.e;
//							iter.remove();
//							break;
//						}
//					}
//				}
			}
			
			System.out.println("#" + t + " " + ans);
		}
	}
	
	private static class XYDE {
		int x;
		int y;
		int d;
		int e;
		boolean flag;
		
		XYDE(int x, int y, int d, int e) {
			this.x = x;
			this.y = y;
			this.d = d;
			this.e = e;
		}
	}
}
