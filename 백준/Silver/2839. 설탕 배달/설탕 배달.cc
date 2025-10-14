#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int a;

    cin >> a;

    if(a % 5 == 0) {
        cout << a / 5 << '\n';

        return 0;
    }

    for(int i = (a / 5); i >= 0; i--) {
        for(int j = 1; 3 * j <= a; j++) {
            if(((i * 5) + (j * 3)) == a) {
                cout << i + j << '\n';
                
                return 0;
            }
        }
    }

    cout << -1 << '\n';
}