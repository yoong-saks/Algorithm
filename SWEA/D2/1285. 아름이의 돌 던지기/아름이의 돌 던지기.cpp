#include <iostream>
#include <map>

using namespace std;

int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        int n;
        map<int, int> m;
        int min = 2147483647;
        cin >> n;

        for(int i = 0; i < n; ++i) {
            int tmp;

            cin >> tmp;

            tmp < 0 ? tmp = -tmp : tmp;

            m[tmp]++;
            if(min > tmp) min = tmp;
        }
        cout << '#' << t << ' ' << min << ' ' << m[min] << '\n';
    }
}