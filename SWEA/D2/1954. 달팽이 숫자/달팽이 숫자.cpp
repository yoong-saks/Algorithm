#include <iostream>
#include <vector>

using namespace std;

// rdlu
int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

void make_snail(int n) {
    vector<vector<int>> board(n, vector<int>(n, 0));

    int x = 0; 
    int y = 0;
    int dir = 0;

    for(int i = 1; i <= n * n; ++i) {
        board[y][x] = i;

        int nx = x + dx[dir];
        int ny = y + dy[dir];

        if(nx < 0 || nx >= n || ny < 0 || ny >= n || board[ny][nx]) {
            dir = (dir + 1) % 4;

            nx = x + dx[dir];
            ny = y + dy[dir];
        }

        x = nx;
        y = ny;
    }

    for(int i = 0; i < n; ++i) {
        for(int j = 0; j < n; ++j) {
            cout << board[i][j] << ' ';
        }
        cout << '\n';
    }
}

int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        int n;

        cin >> n;

        cout << '#' << t << '\n';
        make_snail(n);
    }
}