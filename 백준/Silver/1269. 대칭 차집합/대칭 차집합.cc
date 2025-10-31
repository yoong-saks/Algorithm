#include <iostream>
#include <map>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N, M;
    map<int, bool> m;
    int minus_num = 0;
    
    cin >> N >> M;

    for(int i = 0; i < N; i++) {
        int a;

        cin >> a;

        m[a] = 1;
    }

    for(int i = 0; i < M; i++) {
        int a;

        cin >> a;

        if(m[a]) {
            minus_num++;
        }
    }

    cout << (N - minus_num) + (M - minus_num) << '\n';

}