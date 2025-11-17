#include <iostream>
#include <vector>

using namespace std;

int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        int n;
        vector<bool> v(10, 0);
        int sig = 0;
        cin >> n;
        
        int mult = n;
        for(; sig != 10; n += mult) {
            int tmp = n;

            while(tmp) {
                if(v[tmp % 10]) {
                    tmp /= 10;

                    continue;
                }
                v[tmp % 10] = 1;
                sig++;
                tmp /= 10;
            }
        }
        
        cout << '#' << t << ' ' << n - mult << '\n';
    }
}