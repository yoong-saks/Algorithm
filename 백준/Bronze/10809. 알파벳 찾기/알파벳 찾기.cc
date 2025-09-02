#include <iostream>
#include <vector>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    vector<int> v(26);
    string s;

    fill(v.begin(), v.end(), -1);

    cin >> s;

    for(int i = 0; i < s.size(); i++) {
        if(v[s[i] - 'a'] == -1) {
            v[s[i] - 'a'] = i;
        }
    }

    for(int i : v) {
        cout << i << ' ';
    }
    cout << '\n';
}