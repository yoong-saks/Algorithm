#include <iostream>
#include <map>
#include <vector>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, M;

    cin >> N >> M;

    map<string, string> m1;
    map<string, string> m2;

    for(int i = 0; i < N; i++) {
        string s;

        cin >> s;

        m1[s] = to_string(i + 1);
        m2[to_string(i + 1)] = s;
    }

    vector<string> v;

    for(int i = 0; i < M; i++) {
        string s;

        cin >> s;

        auto iter = m1.find(s);

        if(iter != m1.end()) {
            v.push_back(m1[s]);
        } else {
            v.push_back(m2[s]);
        }

    }

    for(string s : v) {
        cout << s << '\n';
    }
}