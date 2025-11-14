#include <iostream>
#include <string>

using namespace std;

int main() {
    int n;

    cin >> n;

    for(int t = 1; t <= n; t++) {
        string s;
        cin >> s;

        int madi_length = 0;

        for(int len = 1; len <= 10; len++) {
            string madi = s.substr(0, len);
            bool is_correct = true;

            for(int j = 0; j < s.length(); j++) {
                if(s[j] != madi[j % len]) {
                    is_correct = false;
                    break;
                }
            }

            if(is_correct) {
                madi_length = len;
                break;
            }
        }

        cout << '#' << t << ' ' << madi_length << '\n';
    }

    return 0;
}