#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int a;

    cin >> a;
    int ans = a;

    while(a--) {
        string s;

        cin >> s;

        int a[27] = {0,};
        int prev_idx = s[0] - 'a';

        for(char c : s) {
            if((c - 'a' != prev_idx) && (a[c - 'a'])) {
                a[c - 'a'] = -1;
            }

            if(c - 'a' == prev_idx) {
                a[c - 'a'] = 1;
            }

            if(a[c - 'a'] == -1) {
                ans--;
                break;
            }

            a[c - 'a'] = 1;
            prev_idx = c - 'a';
        }
    }

    cout << ans << '\n';
}