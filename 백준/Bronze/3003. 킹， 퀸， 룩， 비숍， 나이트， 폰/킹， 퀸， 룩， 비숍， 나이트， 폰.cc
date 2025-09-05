#include <iostream>
#include <vector>
using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    vector<int> v = {1, 1, 2, 2, 2, 8};
    vector<int> ans;

    for(int i = 0; i < 6; i++) {
        int a;
        cin >> a;

        ans.push_back(v[i] - a);

        cout << ans[i] << ' ';
    }

    cout << '\n';
}