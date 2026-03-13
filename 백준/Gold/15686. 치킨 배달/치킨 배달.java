import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int N, M;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken()); // 맵 크기 (N * N)
		M = Integer.parseInt(st.nextToken()); // 고르는 치킨집 최대 수
		
		// 치킨집의 수는 최대여야지 도시의 치킨거리는 작을 수 밖에 없음.
		
		//치킨집의수(C) M <= C <= 13
		// 13CM임 최대 13C6
		
		ArrayList<IJ> homes = new ArrayList<>();
		ArrayList<IJ> chickens = new ArrayList<>();
		
		
		for(int i = 0; i < N; ++i) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; ++j) {
				int num = Integer.parseInt(st.nextToken());
				
				if(num == 1) homes.add(new IJ(i, j));
				if(num == 2) chickens.add(new IJ(i, j));
			}
		}
		
		int ans = Integer.MAX_VALUE;
		
		for(int bm = 0; bm < (1 << chickens.size()); ++bm) {
			//if(Integer.bitCount(bm) > M) break;
			if(Integer.bitCount(bm) == M) {
				int totalDistance = 0;
				for(int i = 0; i < homes.size(); ++i) {
					IJ start = homes.get(i);
					int minDist = Integer.MAX_VALUE;
					for(int j = 0; j < chickens.size(); ++j) {
						if((bm & (1 << j)) != 0) {
							IJ end = chickens.get(j);
							
							int dist = calculateDist(start, end);
							minDist = Math.min(minDist, dist);
						}
					}
					totalDistance += minDist;
				}
//				for(int i = 0; i < chickens.size(); ++i) {
//					if((bm & (1 << i)) != 0) {
//						int totalDist = 0;
//						IJ start = chickens.get(i);
//						for(int j = 0; j < homes.size(); ++j) {
//							IJ end = homes.get(j);
//							
//							int dist = calculateDist(start, end);
//							totalDist += dist;
//						}
//						totalDistance = Math.min(totalDist, totalDistance);
//					}
//				}
				ans = Math.min(ans, totalDistance);
			}
		}
		
		sb.append(ans);
		System.out.println(ans);
	}
	
	private static int calculateDist(IJ n1, IJ n2) {
		return Math.abs(n1.i - n2.i) + Math.abs(n1.j - n2.j);
	}

	private static class IJ {
		int i;
		int j;
		public IJ(int i, int j) {
			super();
			this.i = i;
			this.j = j;
		}
		
		
	}
}
