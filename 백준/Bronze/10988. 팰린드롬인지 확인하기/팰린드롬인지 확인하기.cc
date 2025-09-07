#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    string s1, s2;

    cin >> s1;
    s2.resize(s1.size());

    reverse_copy(s1.begin(), s1.end(), s2.begin());

    cout << (s1 == s2) << '\n';

}