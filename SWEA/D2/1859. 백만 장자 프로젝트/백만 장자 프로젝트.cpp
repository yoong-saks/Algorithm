#include <iostream>
#include <vector>

using namespace std;

int tc_num;

long long tc() {
    int n;
    long long ans = 0;

    cin >> n;

    vector<int> v;

    for(int i = 0; i < n; ++i) {
        int x;

        cin >> x;
        v.push_back(x);
    }

    int max_price = v[n - 1];

    for(int i = 0; i < n; ++i) {
        if(v[n - i - 1] > max_price) max_price = v[n - i - 1];
        else ans += max_price - v[n - i - 1];
    }

    return ans;
}

int main() {
    cin >> tc_num;

    for(int i = 0; i < tc_num; ++i) {
        long long ans = tc();
        cout << '#' << i + 1 << ' ' << ans << '\n';
    }
}