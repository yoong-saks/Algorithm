#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    vector<pair<int, int>> v;

    int a;

    cin >> a;

    for(int i = 0; i < a; i++) {
        pair<int, int> p;

        cin >> p.first >> p.second;

        v.push_back(p);
    }

    sort(v.begin(), v.end());

    for(int i = 0; i < a; i++) {
        cout << v[i].first << ' ' <<  v[i].second << '\n';

    }
}