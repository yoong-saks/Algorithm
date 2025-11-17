#include <iostream>
#include <vector>

using namespace std;

int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        int n, m;

        cin >> n >> m;

        vector<int> v1(n, 0);
        vector<int> v2(m, 0);

        for(int i = 0; i < n; ++i) {
            int tmp;

            cin >> tmp;

            v1[i] = tmp;
        }

        for(int i = 0; i < m; ++i) {
            int tmp;

            cin >> tmp;

            v2[i] = tmp;
        }

        int gap = m > n ? m - n : n - m;
        int max = -1;
        
        for(int i = 0; i <= gap; ++i) {
            int sum = 0;

            if(n < m) {
                for(int j = 0; j < n; ++j) {
                   sum += v1[j] * v2[j + i];
                }
            } else {
                for(int j = 0; j < m; ++j) {
                   sum += v2[j] * v1[j + i];
                }               
            }

            if(sum > max) max = sum;
        }

        cout << '#' << t << ' ' << max << '\n';
    }

    return 0;
}