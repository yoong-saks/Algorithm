#include <iostream>
#include <cmath>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    string s;
    int a;
    int ans = 0;

    cin >> s >> a;

    for(int i = 0; i < s.size(); i++) {
        int intval;

        if(s[s.size() - i - 1] >= 'A' && s[s.size() - i - 1] <= 'Z') {
            intval = s[s.size() - i - 1] - 'A' + 10;
        } else {
            intval = s[s.size() - i - 1] - '0';
        }

        ans += pow(a, i) * intval;
    }

    cout << ans << '\n';
}