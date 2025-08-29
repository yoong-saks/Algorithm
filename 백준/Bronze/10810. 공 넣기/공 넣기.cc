#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int a, b;

    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> a >> b;

    vector<int> v(a);
    
    while(b--) {
        int x, y, z;

        cin >> x >> y >> z;

        fill(v.begin() + x - 1, v.begin() + y, z);
    }

    for(int i = 0; i < v.size(); i++) {
        cout << v[i];
        if (i < v.size() - 1) {
            cout << ' ';
        }
    }

    cout << '\n';

}