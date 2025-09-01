#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int a;
    string s;
    int sum = 0;

    cin >> a;
    cin >> s;

    for(char c : s) {
        sum += c - '0';
    }
    cout << sum << '\n';

}