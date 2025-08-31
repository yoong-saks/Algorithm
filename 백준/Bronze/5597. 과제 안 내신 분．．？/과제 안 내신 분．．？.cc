#include <iostream>
#include <vector>
#include <numeric>

using namespace std;

int main() {

    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    vector<int> v(30);
    iota(v.begin(), v.end(), 1);

    for(int i = 0; i < 30; i++) {
        int x;

        cin >> x;

        v[x - 1] = 0;
    }

    for(int i = 0; i < 30; i++) {
        if(v[i] != 0) {
            cout << v[i] << '\n';
        }
    }
}