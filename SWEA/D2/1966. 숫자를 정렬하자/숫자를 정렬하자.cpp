#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        int n;

        cin >> n;

        vector<int> v(n, 0);

        for(int i = 0; i < n; ++i) {
            int tmp;

            cin >> tmp;

            v[i] = tmp;
        }

        sort(v.begin(), v.end());

        cout << '#' << t << ' ';

        for(int i : v) {
            cout << i << ' ';
        }
        
        cout << '\n';
    }

    return 0;
}