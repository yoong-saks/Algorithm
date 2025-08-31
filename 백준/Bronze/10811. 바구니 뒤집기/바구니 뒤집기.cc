#include <iostream>
#include <vector>
#include <numeric>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int a, b;

    cin >> a >> b;

    vector<int> v(a);
    iota(v.begin(), v.end(), 1);

    while(b--) {
        int x, y;

        cin >> x >> y;

        reverse(v.begin() + x - 1, v.begin() + y);
    }

    for(int i : v) {
        cout << i << ' ';
    }
    cout << '\n';
}