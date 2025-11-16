#include <iostream>

using namespace std;


int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        int n;
        
        cin >> n;

        int ans = 0;
        for(int i = 1; i <= n; ++i) {
            ans += (i % 2 == 0 ? -i : i);
        }

        cout << '#' << t << ' ' << ans << '\n';
    }
}