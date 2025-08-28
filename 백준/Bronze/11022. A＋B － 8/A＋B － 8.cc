#include <iostream>

using namespace std;

int main() {
    int a;

    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> a;

    for(int i = 0; i < a; i++) {
        int b, c;
        cin >> b >> c;
        cout << "Case #" << i + 1 << ": " << b << " + " << c << " = " << b + c << '\n';
    }

}