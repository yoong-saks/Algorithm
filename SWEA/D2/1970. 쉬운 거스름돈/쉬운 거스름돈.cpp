#include <iostream>
#include <vector>

using namespace std;

int change[8] = {50000, 10000, 5000, 1000, 500, 100, 50, 10};

int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        int n;
        
        cin >> n;

        vector<int> v(8, 0);

        for(int i = 0; i < 8; ++i) {
            if(n >= change[i]) {
                v[i] += n / change[i];

                n -= change[i] * (n / change[i]);
            }
        }

        cout << '#' << t <<'\n';
        for(int i : v) {
            cout << i << ' ';
        }
        cout << '\n';
    }

    return 0;
}

