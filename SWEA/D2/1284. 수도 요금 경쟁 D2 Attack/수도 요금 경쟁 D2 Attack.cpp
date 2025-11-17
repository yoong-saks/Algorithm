#include <iostream>

using namespace std;

int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        int p, q, r, s, w;

        cin >> p >> q >> r >> s >> w;

        int a_price = p * w;
        int b_price = q;
        if(w > r) {
            b_price += (w - r) * s;
        }

        int ans = a_price > b_price ? b_price : a_price;

        cout << '#' << t << ' ' << ans << '\n';
    }
}