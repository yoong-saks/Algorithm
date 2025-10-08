#include <iostream>
#include <vector>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int ans = 0;

    vector<int> v;
    int n, m;

    cin >> n >> m;
    
    for(int i = 0; i < n; i++) {
        int input_value;

        cin >> input_value;
        v.push_back(input_value);
    }

    for(int i = 0; i < n - 2; i++) {
        for(int j = i + 1; j < n - 1; j++) {
            for(int k = j + 1; k < n; k++) {
                if(v[i] + v[j] + v[k] > m) {
                    continue;
                } else if(v[i] + v[j] + v[k] - ans >= 0) {
                    ans = v[i] + v[j] + v[k];
                }
            }
        }
    }

    cout << ans << '\n';

}