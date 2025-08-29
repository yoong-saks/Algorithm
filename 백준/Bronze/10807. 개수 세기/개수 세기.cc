#include <iostream>
#include <vector>

using namespace std;

int main() {
    vector<int> v;
    int a;
    int ans = 0;

    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> a;

    for (int i = 0; i < a; i++) {
        int t;
        cin >> t;
        v.push_back(t);
    }

    cin >> a;
    
    for(int i = 0; i < v.size(); i++) {
        if(v[i] == a) {
            ans++;
        }
    }
    cout << ans << '\n';

}