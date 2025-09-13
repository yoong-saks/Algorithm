#include <iostream>
#include <vector>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    vector<vector<int>> v(100, vector<int> (100));
    int a;

    cin >> a;
    
    while(a--) {
        int xidx, yidx;
        cin >> xidx >> yidx;

        for(int i = xidx; i < xidx + 10; i++) {
            for (int j = yidx; j < yidx + 10; j++) {
                v[i][j] = 1;
            }
        }
    }

    int ans = 0;
    for(int i = 0; i < 100; i++) {
        for (int j = 0; j < 100; j++) {
            ans += v[i][j];
        }
    }

    cout << ans << '\n';
}