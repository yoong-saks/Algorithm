#include <iostream>
#include <cstring>

using namespace std;

int dp[11][11];

int get_pascal(int i, int j) {
    if(j == 1 || j == i) {
        return 1;
    }
    if(dp[i][j]) {
        return dp[i][j];
    }

    dp[i][j] = get_pascal(i - 1, j - 1) + get_pascal(i - 1, j);

    return dp[i][j];
}
int main() {
    int T;

    cin >> T;

    for(int tc = 1; tc <= T; ++tc) {
        int n;

        cin >> n;

        memset(dp, 0, sizeof(dp));
        
        cout << '#' << tc << '\n';

        for(int i = 1; i <= n; ++i) {
            for(int j = 1; j <= i; ++j) {
                cout << get_pascal(i, j) << ' ';
            }
            cout << '\n';
        }
    }
}