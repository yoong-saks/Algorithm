#include <iostream>

using namespace std;

int main() {
    int a, b;
    int sum = 0;

    cin >> a >> b;

    for (int i = 0, x, y; i < b; i++) {
        cin >> x >> y;

        sum += x * y;
    }

    if (sum == a) {
        cout << "Yes" << endl;
    } else {
        cout << "No" << endl;
    }
}