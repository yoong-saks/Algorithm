#include <iostream>
#include <string>

using namespace std;

int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        int n;

        cin >> n;

        string s = "";

        int total_len = 0;

        for(int i = 0; i < n; ++i) {
            char c;
            int tmp;

            cin >> c >> tmp;
            s.append(tmp, c);

            total_len += tmp;
        }

        cout << '#' << t << '\n';

        for(int i = 0; i <= total_len / 10; ++i) {
            int pos = 0;

            for(int j = 0; j < 10; ++j) {
                if(i * 10 + pos >= s.size()) break;
                cout << s[i * 10 + pos];
                pos++;
            }
            cout << '\n';
        }
    }
    return 0;
}