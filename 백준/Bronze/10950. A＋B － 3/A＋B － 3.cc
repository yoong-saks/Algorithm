#include <iostream>

using namespace std;

int main() {
    int a;

    cin >> a;

    for (int i, b, c = 0; i < a; i++) {
        cin >> b >> c;

        cout << b + c << endl;
    }
}