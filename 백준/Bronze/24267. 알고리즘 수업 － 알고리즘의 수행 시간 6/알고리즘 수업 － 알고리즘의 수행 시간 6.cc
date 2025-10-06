#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    long long a;

    cin >> a;
    
    cout << ((a - 2) * (a - 1) * a) / 6 << '\n';
    cout << 3 << '\n';
}