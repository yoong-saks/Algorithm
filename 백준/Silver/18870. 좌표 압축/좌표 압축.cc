#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    vector<int> v;

    int a;

    cin >> a;

    for(int i = 0; i < a; i++) {
        int X;

        cin >> X;
        v.push_back(X);
    }

    vector<int> v_copy = v;

    sort(v_copy.begin(), v_copy.end());

    v_copy.erase(unique(v_copy.begin(), v_copy.end()), v_copy.end());

    for(int i : v) {
        cout << lower_bound(v_copy.begin(), v_copy.end(), i) - v_copy.begin() << ' ';
    }
    cout << '\n';
}