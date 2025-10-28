#include <iostream>
#include <map>
#include <vector>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, M;
    map<int, int> m;
    vector<int> ans;

    cin >> N;

    for(int i = 0; i < N; i++) {
        int a;

        cin >> a;

        m[a]++;
    }

    cin >> M;

    for(int i = 0; i < M; i++) {
        int a;

        cin >> a;

        ans.push_back(m[a]);
    }

    for(int i : ans) {
        cout << i << ' ';
    }
    cout << '\n';
}