#include <iostream>
#include <vector>

using namespace std;

struct IJ {
    int i, j;
};

int di[4] = {0, 1, 0, -1};
int dj[4] = {1, 0, -1, 0};

int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        int N;

        cin >> N;

        vector<vector<int>> v(N, vector<int>(N, 0));

        int dir = 0;

        IJ cur = {0, 0};
        
        for(int i = 1; i <= N * N; ++i) {
            v[cur.i][cur.j] = i;

            int ni = cur.i + di[dir];
            int nj = cur.j + dj[dir];

            if(!(0 <= ni && ni < N) || !(0 <= nj && nj < N) || v[ni][nj]) {
                dir = (dir + 1) % 4;

                ni = cur.i + di[dir];
                nj = cur.j + dj[dir];
            }

            cur.i = ni;
            cur.j = nj;
        }

        cout << '#' << t << endl;

        for(int i = 0; i < N; ++i) {
            for(int j = 0; j < N; ++j) {
                cout << v[i][j] << ' ';
            }
            cout << endl;
        }
    }

}