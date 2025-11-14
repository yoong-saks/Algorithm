#include <sstream>
#include <iostream>
#include <string>

using namespace std;

int main() {
    int n;

    cin >> n;

    for(int i = 1; i <= n; ++i) {
        stringstream ss;
        ss << i;

        char ch;
        int cnt = 0;
        string s;

        while(ss >> ch) {
            if(ch == '3' || ch == '6' || ch == '9') cnt++;
            else s += ch;
        }

        if(cnt) {
            s.clear();
            s.append(cnt, '-');
        }

        cout << s << ' ';
    }
    cout << '\n';

    return 0;
}