#include <iostream>

using namespace std;

int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        int h1, m1, h2, m2;
        int ans_h = 0;
        int ans_m = 0;

        cin >> h1 >> m1 >> h2 >> m2;

        if(m1 + m2 > 59) ans_h += 1;

        ans_m = (m1 + m2) % 60;
        ans_h += h1 + h2;

        if(ans_h > 12) {
            ans_h = ans_h % 12;
            if(!ans_h) ans_h = 12;
        }
        
        cout << '#' << t << ' ' << ans_h << ' ' << ans_m << '\n';
    }
}