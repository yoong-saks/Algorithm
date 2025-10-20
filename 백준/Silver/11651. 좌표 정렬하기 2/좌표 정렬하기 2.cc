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

    sort(v.begin(), v.end(), [](const pair<int, int>& a, const pair<int, int>& b) {
        if(a.second == b.second) {
            return a.first < b.first;
        }

        return a.second < b.second;
    });

    for(int i = 0; i < a; i++) {
        cout << v[i].first << ' ' <<  v[i].second << '\n';

    }
}