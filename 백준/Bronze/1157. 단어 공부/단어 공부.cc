#include <iostream>
#include <cctype>
#include <algorithm>
using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    vector<int> v(26, 0);

    string s;

    cin >> s;

    for(int i = 0; i < s.size(); i++) {
        s[i] = toupper(s[i]);
        v[s[i] - 'A']++;
    }

    vector<int> v2(v);
    sort(v2.rbegin(), v2.rend());

    auto it = find(v.begin(), v.end(), v2[0]);

    if(v2[0] != v2[1]) {
        cout << (char)(it - v.begin() + 'A') << '\n';
    }
    else {
        cout << '?' << '\n';
    }
}