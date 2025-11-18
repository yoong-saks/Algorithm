#include <iostream>
#include <vector>

using namespace std;

int calculate_goodview() {
    int n;

    cin >> n;

    vector<int> v(n, 0);
    int ans = 0;

    for(int i = 0; i < n; ++i) {
        int tmp;
        
        cin >> tmp;
        v[i] = tmp;
    }

    for(int i = 2; i < n - 2; ++i) {
        if(v[i] <= v[i - 1] || v[i] <= v[i - 2] || v[i] <= v[i + 1] || v[i] <= v[i + 2]) {
            continue;
        }
        int other_top = max(v[i - 2], max(v[i - 1], max(v[i + 1], v[i + 2])));

        ans += v[i] - other_top;
    }

    return ans;
}

int main() {
    for(int t = 1; t <= 10; ++t) {
        int ans = calculate_goodview();

        cout << '#' << t << ' ' << ans << '\n';
    }
    
    return 0;
}