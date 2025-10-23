#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    vector<pair<int, string>> v;

    int a;

    cin >> a;

    for(int i = 0; i < a; i++) {
        pair<int, string> p;

        cin >> p.first >> p.second;

        v.push_back(p);
    }

    stable_sort(v.begin(), v.end(), [](const pair<int, string>& a, const pair<int, string>& b) {
        return a.first < b.first;
    });

    for(int i = 0; i < v.size(); i++) {
        cout << v[i].first << ' ' << v[i].second << '\n';
    }
}