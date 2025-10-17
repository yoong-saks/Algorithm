#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, k;
    vector<int> v;

    cin >> N >> k;

    for(int i = 0; i < N; i++) {
        int a;

        cin >> a;

        v.push_back(a);
    }

    sort(v.rbegin(), v.rend());

    cout << v[k - 1] << '\n';
}