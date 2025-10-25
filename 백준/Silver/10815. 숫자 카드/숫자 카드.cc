#include <iostream>
#include <map>
#include <vector>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    map<int, bool> m;

    int N;
    
    cin >> N;

    for(int i = 0; i < N; i++) {
        int x;

        cin >> x;
        m[x] = 1;
    }

    int M;

    cin >> M;
    vector<int> v;

    for(int i = 0; i < M; i++) {
        int x;

        cin >> x;

        v.push_back(x);
    }

    for(int i : v) {
        cout << m[i] << ' ';
    }
    cout << '\n';
}