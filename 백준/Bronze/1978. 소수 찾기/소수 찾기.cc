#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int a;

    cin >> a;
    
    int ans = a;

    for(int j = 0; j < a; j++) {
        int b;
        cin >> b;
        if(b == 1) {
            ans--;
            continue;
        }

        for(int i = 2; i < b; i++) {
            if(b % i == 0) {
                ans--;
                break;
            }
        }
    }

    cout << ans << '\n';
}