#include <iostream>
#include <cmath>

using namespace std;

int square_divide(int x, int y);

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int a;
    
    cin >> a;

    cout << square_divide(a, 4) << '\n';

        
}

int square_divide(int x, int y) {
    if(x == 1) {
        return y + 5;
    }
    
    return ((4 * square_divide(x - 1, y)) - (2 * pow(2, x)) - 3);
}