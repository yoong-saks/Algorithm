import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[][] map = new int[100][100];
    private static int[][] labeledMap = new int[100][100];
    private static int[][] visited;

    private static int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        visited = new int[N][N];

        for(int i = 0; i < N; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; ++j) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int islandNum = 1;
        Queue<IJ> q2 = new ArrayDeque<>();

        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < N; ++j) {
                if(map[i][j] == 1) {
                    if(labeledMap[i][j] == 0) {
                        Queue<IJ> q = new ArrayDeque<>();

                        q.add(new IJ(i, j));
                        q2.add(new IJ(i, j, islandNum, 0));
                        labeledMap[i][j] = islandNum;

                        while(!q.isEmpty()) {
                            IJ cur = q.poll();
                            
                            for(int d = 0; d < 4; ++d) {
                                int ni = cur.i + dir[d][0];
                                int nj = cur.j + dir[d][1];

                                if(!(0 <= ni && ni < N) || !(0 <= nj && nj < N)) continue;
                                if(labeledMap[ni][nj] == islandNum) continue;
                                if(map[ni][nj] == 0) continue;

                                labeledMap[ni][nj] = islandNum;
                                q.offer(new IJ(ni, nj));
                                q2.add(new IJ(ni, nj, islandNum, 0));
                            }
                        }
                        islandNum++;
                    }
                }
            }
        }

        int ans = Integer.MAX_VALUE;

        while(!q2.isEmpty()) {
            IJ cur = q2.poll();
            
            if(cur.dist >= ans) break;

            for(int d = 0; d < 4; ++d) {
                int ni = cur.i + dir[d][0];
                int nj = cur.j + dir[d][1];

                if(!(0 <= ni && ni < N) || !(0 <= nj && nj < N)) continue;
                if(labeledMap[ni][nj] == cur.source) continue;
                if(labeledMap[ni][nj] != 0) {
                    ans = Math.min(ans, cur.dist + visited[ni][nj]);
                    continue;
                }

                labeledMap[ni][nj] = cur.source;
                visited[ni][nj] = cur.dist + 1;
                q2.offer(new IJ(ni, nj, cur.source, cur.dist + 1));
            }
        }

        System.out.println(ans);
    }

    private static class IJ {
        int i;
        int j;
        int source;
        int dist;

        IJ(int i, int j) {
            this.i = i;
            this.j = j;
        }

        IJ(int i, int j, int source, int dist) {
            this.i = i;
            this.j = j;
            this.source = source;
            this.dist = dist;
        }
    }
}
