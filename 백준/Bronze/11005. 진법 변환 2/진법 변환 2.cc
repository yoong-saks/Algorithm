#include <iostream>
#include <string>
using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int a, b;
    string ans = "";

    cin >> a >> b;

    int tmp = 0;

    while(a >= b) {

        tmp = a % b;
        a /= b;

        if(tmp > 9) {
            ans = char((tmp - 10 + 'A')) + ans;
        } else {
            ans = char((tmp + '0')) + ans;
        }
    }

    tmp = a % b;

    if(tmp > 9) {
        ans = char((tmp - 10 + 'A')) + ans;
    } else {
        ans = char((tmp + '0')) + ans;
    }

    cout << ans << endl;
}