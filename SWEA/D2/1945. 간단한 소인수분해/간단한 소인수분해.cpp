#include <iostream>
#include <vector>

using namespace std;

int prime_num[5] = {2, 3, 5 ,7, 11};

int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        int n;
        vector<int> v(5, 0);

        cin >> n;

        while(n != 1) {
            for(int i = 0; i < 5; ++i) {
                if(n % prime_num[i] == 0) {
                    n /= prime_num[i];
                    v[i]++;
                }
            }
        }

        cout << '#' << t << ' ';

        for(int i = 0; i < 5; ++i) {
            cout << v[i] << ' ';
        }

        cout << '\n';
    }
}