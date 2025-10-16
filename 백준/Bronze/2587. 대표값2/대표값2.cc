#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int sum = 0;
    vector<int> v;

    for(int i = 0; i < 5; i++) {
        int a;

        cin >> a;

        sum += a;
        v.push_back(a);
    }

    sort(v.begin(), v.end());

    cout << sum / 5 << '\n';
    cout << v[2] << '\n';
}