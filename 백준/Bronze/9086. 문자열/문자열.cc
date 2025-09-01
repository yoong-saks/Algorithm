#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int a;
    string s;

    cin >> a;

    while(a--) {
        cin >> s;
        cout << s[0] << s[s.size() - 1] << '\n';
    }

}