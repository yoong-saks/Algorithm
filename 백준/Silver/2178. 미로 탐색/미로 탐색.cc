#include <iostream>
#include <string>
#include <queue>

using namespace std;

int di[4] = {-1, 0, 1, 0};
int dj[4] = {0, 1, 0, -1};
int m[101][101];

struct IJT {
    int i, j, t;
};

int main() {
    int N, M;

    cin >> N >> M;

    for(int i = 0; i < N; ++i) {
        string s;

        cin >> s;
        for(int j = 0; j < M; ++j) {
            m[i][j] = s[j] - '0';
        }
    }

    queue<IJT> q;
    q.push({0, 0, 1});
    m[0][0] = 0;

    while(!q.empty()) {
        IJT cur = q.front();
        q.pop();

        

        for(int d = 0; d < 4; ++d) {
            int ni, nj;

            ni = cur.i + di[d];
            nj = cur.j + dj[d];

            if(!(0 <= ni && ni < N)) continue;
            if(!(0 <= nj && nj < M)) continue;
            if(m[ni][nj] == 0) continue;
            if(ni == N - 1 && nj == M - 1) {
                cout << cur.t + 1 << endl;

                return 0;
            }

            m[ni][nj] = 0;
            q.push({ni, nj, cur.t + 1});
        }
    }
}