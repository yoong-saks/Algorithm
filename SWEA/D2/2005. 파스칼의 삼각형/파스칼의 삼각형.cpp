#include <iostream>
#include <cstring>

using namespace std;

int dp[11][11];

int get_pascal(int x, int y) {
    if(y == 1 || x == y) {
        return 1;
    }

    if(dp[x][y]) {
        return dp[x][y];
    }

    dp[x][y] = get_pascal(x - 1, y - 1) + get_pascal(x - 1, y);

    return dp[x][y];
}

int main() {
    int T;

    cin >> T;

    for(int tc = 1; tc <= T; ++tc) {
        int N;

        cin >> N;

        memset(dp, 0, sizeof(dp));

        cout << '#' << tc << '\n';

        for(int i = 1; i <= N; ++i) {
            for(int j = 1; j <= i; ++j) {
                cout << get_pascal(i, j) << ' ';
            }
            cout << '\n';
        }
    }
}