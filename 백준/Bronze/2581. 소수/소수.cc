#include <iostream>
#include <vector>
#include <cmath>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int a, b;

    vector<bool> is_prime(10001, 1);

    is_prime[1] = 0;

    for(int i = 2; i <= sqrt(10001); i++) {
        if(!is_prime[i]) continue;
        for(int j = 2; j * i <= 10001; j++) {
            is_prime[i * j] = false;
        }
    }

    cin >> a >> b;
    
    int sum = 0;
    int first_prime = 0;

    for(int i = a; i <= b; i++) {
        if(is_prime[i]) {
            if(first_prime == 0) {
                first_prime = i;
            }

            sum += i;
        }
    }

    if(sum == 0) {
        cout << "-1" << '\n';

        return 0;
    }

    cout << sum << '\n' << first_prime << '\n';

    return 0;
}