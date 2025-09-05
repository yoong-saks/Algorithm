#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int a;

    cin >> a;

    for(int i = a; i <= 2 * a - 1; i++) {

        for(int j = 0; j < 2 * a - 1 - i; j++) {
            cout << ' ';
        }

        cout << '*';

        for(int j = a; j < i; j++) {
            cout << "**";
        }
        cout << '\n';
    }
    for(int i = 2 * a - 2; i >= a; i--) {

        for(int j = 0; j < 2 * a - 1 - i; j++) {
            cout << ' ';
        }
        cout << '*';

        for(int j = a; j < i; j++) {
            cout << "**";
        }
        cout << '\n';
    }
}