#include <iostream>
#include <vector>

using namespace std;

int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        int n, k;

        cin >> n >> k;

        vector<int> v(n + 1, 0);
        vector<vector<int>> v2(n, vector<int>(n, 0));

        for(int i = 0; i < n; ++i) {
            int tmp = 0;
            for(int j = 0; j < n; ++j) {
                int newer;

                cin >> newer;
                v2[i][j] = newer;

                if(newer) tmp++;
                else {
                    if(tmp > 1) v[tmp]++;
                    tmp = 0;
                }
            }
            if(tmp) {
                v[tmp]++;
            }
        }

        for(int i = 0; i < n; ++i) {
            int tmp = 0;
            for(int j = 0; j < n; ++j) {
                if(v2[j][i]) tmp++;
                else {
                    if(tmp > 1) v[tmp]++;
                    tmp = 0;
                }
            }
            if(tmp) {
                v[tmp]++;
            }
        }

        cout << '#' << t << ' ' << v[k] << '\n';
    }
}