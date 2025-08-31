#include <iostream>
#include <vector>
#include <numeric>

using namespace std;

int main() {
    int a, b;

    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> a >> b;

    vector<int> v(a);
    iota(v.begin(), v.end(), 1);
    
    while(b--) {
        int x, y, t;

        cin >> x >> y;

        t = v[x - 1];
        v[x - 1] = v[y - 1];
        v[y - 1] = t;
    }

    for(int i = 0; i < v.size(); i++) {
        cout << v[i];
        if (i < v.size() - 1) {
            cout << ' ';
        }
    }

    cout << '\n';

}