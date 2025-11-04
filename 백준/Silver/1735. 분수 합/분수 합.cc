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

    int A, B, C, D;

    cin >> A >> B;
    cin >> C >> D;

    int down = B * D / gcd(B, D);
    int up = (A * (down / B)) + (C * (down / D));

    while(gcd(down, up) != 1) {
        int lcm = gcd(down, up);

        up /= lcm;
        down /= lcm;
    }

    cout << up << ' ' << down << '\n';
}