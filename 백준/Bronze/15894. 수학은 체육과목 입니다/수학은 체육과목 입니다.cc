#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    long long x;

    cin >> x;

    cout << x + (x * 2) + x << '\n';
}