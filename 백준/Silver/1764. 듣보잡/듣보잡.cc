#include <iostream>
#include <map>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, M;
    map<string, bool> m;
    vector<string> v;
    
    cin >> N >> M;

    for(int i = 0; i < N + M; i++) {
        string s;

        cin >> s;

        if(m[s]) {
            v.push_back(s);
        }
        m[s] = 1;
    }

    cout << v.size() << '\n';

    sort(v.begin(), v.end());

    for(string s : v) {
        cout << s << '\n';
    }

}