#include <iostream>
#include <string>

using namespace std;

int main() {

    string s;
    int T;

    cin >> T;

    for(int t = 0; t < T; ++t) {
        cin >> s;

        string ps = "";

        for(int i = 0; i < s.length(); ++i) {
            ps += s[s.length() - 1 - i];
        }
        
        if(s == ps) cout << '#' << t + 1 << ' ' << 1 << '\n';
        else cout << '#' << t + 1 << ' ' << 0 << '\n';
    }
}