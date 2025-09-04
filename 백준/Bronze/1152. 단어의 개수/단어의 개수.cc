#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    string s1;
    int ans = 1;

    getline(cin, s1);

    for(char c : s1) {
        if(c == ' ') {
            ans++;
        }
    }
    if(s1[0] == ' ') ans--;
    if(s1[s1.size() - 1] == ' ') ans--;

    cout << ans << '\n';
}