#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    string s;
    int a;

    cin >> s >> a;

    cout << s[a - 1] << '\n';

}