#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int a, b, c;
    int ans = 0;

    cin >> a >> b >> c;

    ans = c / (a - b);

    while((ans * (a - b)) + a >= c) {
        ans--;
    }
    
    cout << ans + 2 << '\n';
}
