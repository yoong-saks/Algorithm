#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int a_one, a_zero, c, n_zero;

    cin >> a_one >> a_zero;
    cin >> c;
    cin >> n_zero;

    int n = n_zero;

    if((a_one * n) + a_zero > c * n) {
        cout << 0 << '\n';
    } else if(a_one >= c) {
        if(a_one == c && a_zero <= 0) {
            cout << 1 << '\n';
        } else {
            cout << 0 << '\n';
        }
    } else {
        cout << 1 << '\n';
    }
}