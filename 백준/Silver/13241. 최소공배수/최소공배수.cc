#include <iostream>

using namespace std;

int gcd(int a, int b) {
    int x = max(a, b);
    int y = min(a, b);

    while(y != 0) {
        int tmp = x % y;
        x = y;
        y = tmp;
    }

    return x;
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    long long int A, B;

    cin >> A >> B;

    cout << A * B / gcd(A, B) << '\n';

}