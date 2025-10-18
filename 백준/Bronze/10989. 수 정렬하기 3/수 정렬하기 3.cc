#include <iostream>
#include <vector>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int a;

    cin >> a;

    vector<int> v(10000, 0);

    int max = 0;

    for(int i = 0; i < a; i++) {
        int N;

        cin >> N;

        if(N > max) max = N;
        v[N - 1]++;
    }

    for(int i = 0; i < max; i++) {
        for(int j = 1; j <= v[i]; j++) {
            cout << i + 1 << '\n';
        }
    }
}