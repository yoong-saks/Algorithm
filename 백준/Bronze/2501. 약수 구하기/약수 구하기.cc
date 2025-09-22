#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int a, b;
    int cnt = 0;

    cin >> a >> b;

    for(int i = 1; i <= (a / 2); i++) {
        if(a % i == 0) {
            cnt++;
        }

        if(cnt == b) {
            cout << i << '\n';
            break;
        } else if(cnt == (b - 1)) {
            if(a % 2 == 1) {
                if((i * 2 + 1) == a) {
                    cnt = b;
                    cout << i * 2 + 1 << '\n';
                    break;
                }
            } else {
                if(i * 2 == a) {
                    cnt = b;
                    cout << i * 2 << '\n';
                    break;
                }
            }
        }
    }


    if(cnt < b) {
        cout << '0' << '\n';
    }
}
