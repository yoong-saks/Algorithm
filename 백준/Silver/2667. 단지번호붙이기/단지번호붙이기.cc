#include <iostream>
#include <string>
#include <queue>
#include <algorithm>

using namespace std;

struct IJ {
    int i, j;
};

int di[4] = {-1, 0, 1, 0};
int dj[4] = {0, 1, 0, -1};
int ans;

int board[25][25];

int main() {
    int N;
    vector<int> ans_v;

    cin >> N;

    for(int i = 0; i < N; ++i) {
        string s;

        cin >> s;

        for(int j = 0; j < N; ++j) {
            board[i][j] = s[j] - '0';
        }
    }

    for(int i = 0; i < N; ++i) {
        for(int j = 0; j < N; ++j) {
            if(board[i][j]) {
                ans += 1;

                int buildings = 0;
                queue<IJ> q;

                q.push({i, j});
                board[i][j] = 0;

                while(!q.empty()) {
                    IJ cur = q.front();
                    q.pop();
                    buildings++;

                    for(int d = 0; d < 4; ++d) {
                        int ni = cur.i + di[d];
                        int nj = cur.j + dj[d];

                        if(!(0 <= ni && ni < N)) continue;
                        if(!(0 <= nj && nj < N)) continue;
                        if(board[ni][nj] == 0) continue;

                        board[ni][nj] = 0;
                        q.push({ni, nj});
                    }
                }

                ans_v.push_back(buildings);
            }
        }
    }
    
    cout << ans << endl;

    sort(ans_v.begin(), ans_v.end());

    for(int i : ans_v) {
        cout << i << endl;
    }
}