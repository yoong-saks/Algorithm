#include <iostream>
#include <map>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, M;
    int ans = 0;

    cin >> N >> M;

    map<string, int> m;
    for(int i = 0; i < N; i++) {
        string s1;

        cin >> s1;

        m[s1]++;
    }

    for(int i = 0; i < M; i++) {
        string s1;

        cin >> s1;

        if(m[s1] == 1) {
            ans++;
        }
    }
    cout << ans << '\n';
}