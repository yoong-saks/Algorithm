import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	private static int N;
	private static int W;
	private static int H;
	private static List<Integer>[] map;
	private static int ans;
	
	public static void main(String[] args) throws Exception {
		// System.setIn(new FileInputStream("res/input.txt"));
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; ++t) {
			st = new StringTokenizer(br.readLine());

			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			H = Integer.parseInt(st.nextToken());
			
			map = new List[W];
			
			ans = Integer.MAX_VALUE;
			
			for(int i = 0; i < W; ++i) {
				map[i] = new LinkedList<>();
			}
			
			for(int i = 0; i < H; ++i) {
				st = new StringTokenizer(br.readLine());
	
				for(int j = 0; j < W; ++j) {
					int num = Integer.parseInt(st.nextToken());
					
					if(num != 0) {
						map[j].add(0, num);
					}
				}
			}
			
			dfs(0);
			
			System.out.println("#" + t + " " + ans);
		}
		
	}
	
	private static void dfs(int cnt) {
		if(cnt == N) {
			int sum = 0;
			
			for(int i = 0; i < W; ++i) {
				sum += map[i].size();
			}
			
//			if(ans > sum) {
//				for(int i = 0; i < W; ++i) {
//					for(Integer j : map[i]) {
//						System.out.print(j);
//					}
//					System.out.println();
//				}
//			}
			ans = Math.min(ans, sum);
			return;
		}
		
		List<Integer>[] backupMap = new LinkedList[W];
		for(int i = 0; i < W; ++i) {
			backupMap[i] = new LinkedList<>(map[i]);
		}
		
		for(int i = 0; i < W; ++i) {
			int topIdx = map[i].size() - 1;
			if(topIdx < 0) topIdx = 0;
			
			destroyBrick(i, topIdx);
			organizeMap();
			
			dfs(cnt + 1);
			
			for(int j = 0; j < W; ++j) {
				map[j] = new LinkedList<>(backupMap[j]);
			}
			
		}
	}
	
	private static void destroyBrick(int colIdx, int topIdx) {
		if(map[colIdx].size() - 1 < topIdx) return;
		
		int top = map[colIdx].get(topIdx);
		map[colIdx].set(topIdx, 0);
		
		for(int i = -top + 1; i < top; ++i) {
			int nj = topIdx + i;
			
			if(nj < 0) nj = 0;
			
			if(nj == topIdx) continue;
			if(map[colIdx].size() == 0) continue;
			if(nj > map[colIdx].size() - 1) continue;
			
			destroyBrick(colIdx, nj);
		}
		
		for(int i = -top + 1; i < top; ++i) {
			int ni = colIdx + i;
			
			if(ni == colIdx) continue;
			if(!(0 <= ni && ni < W)) continue;
			if(map[ni].size() == 0) continue;
			if(map[ni].size() - 1 < topIdx) continue;
			if(map[ni].get(topIdx) == 0) continue;
			
			destroyBrick(ni, topIdx);
		}
	}
	
	private static void organizeMap() {
		for(int i = 0; i < W; ++i) {
			for(int j = map[i].size() - 1; j >= 0; --j) {
				
				if(map[i].get(j) == 0) map[i].remove(j);
			}
		}
	}
	
}
