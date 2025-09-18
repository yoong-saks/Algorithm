#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int a;
    int init_x = 1;
    int tmp = 1;
    int ans = 1;

    cin >> a;

    while(a > init_x) {
        init_x += 6 * tmp++;
        ans++;
    }
    
    cout << ans << '\n';
}
