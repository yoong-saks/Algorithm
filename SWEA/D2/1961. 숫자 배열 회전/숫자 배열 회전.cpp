#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        int n;

        cin >> n;

        vector<vector<int>> v(n, vector<int>(n, 0));

        for(int i = 0; i < n; ++i) {
            for(int j = 0; j < n; ++j) {
                int tmp;

                cin >> tmp;
                v[i][j] = tmp;
            }
        }

        cout << '#' << t << '\n';

        for(int i = 0; i < n; ++i) {
            string rotate90 = "";
            string rotate180 = "";
            string rotate270 = "";

            for(int j = 0; j < n; ++j) {
                rotate90 += v[n - j - 1][i] + '0';
                rotate180 += v[n - i - 1][n - j - 1] + '0';
                rotate270 += v[j][n - i - 1] + '0';
            }
            cout << rotate90 << ' ' << rotate180 << ' ' << rotate270 << '\n';
            
        }
    }
}