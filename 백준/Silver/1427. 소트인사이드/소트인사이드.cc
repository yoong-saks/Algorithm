#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    string s;

    cin >> s;

    sort(s.rbegin(), s.rend());

    cout << s << '\n';
}