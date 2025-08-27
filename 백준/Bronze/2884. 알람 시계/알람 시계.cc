#include <iostream>

using namespace std;

int main() {
    int a, b;

    cin >> a >> b;

    if (b - 45 < 0) {
        b += 15;
        
        if (a - 1 < 0) {
            a += 23;
        } else {
            a -= 1;
        }
    } else {
        b -= 45;
    }

    cout << a << " " << b << endl;
}