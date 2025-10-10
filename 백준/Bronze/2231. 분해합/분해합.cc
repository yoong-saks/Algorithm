#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int n;

    cin >> n;

    for(int i = 1; i <= n; i++) {
        int tmp = i;
        int sum = tmp;
        while(tmp) {
            sum += tmp % 10;
            tmp /= 10;
        }

        if(sum == n) {
            cout << i << '\n';
            break;
        }

        if(i == n && sum != n) {
            cout << 0 << '\n';
            break;
        }
    }

}