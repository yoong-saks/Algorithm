#include <iostream>

using namespace std;

int month[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        int m1, d1, m2, d2;

        cin >> m1 >> d1 >> m2 >> d2;

        int days = 0;

        for(int i = m1; i <= m2; ++i) {
            days += month[i - 1];
        }

        days = days - d1;
        days = days - (month[m2 - 1] - d2);

        cout << '#' << t << ' ' << days + 1 << '\n';
    }
}