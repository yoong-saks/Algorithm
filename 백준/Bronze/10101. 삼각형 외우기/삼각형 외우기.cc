#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int a1, a2, a3;

    cin >> a1 >> a2 >> a3;
    
    if((a1 ^ a2 ^ a3) == 60) {
        cout << "Equilateral" << '\n';
    } else if(a1 + a2 + a3 == 180) {
        if(a1 == a2 || a2 == a3 || a1 == a3) {
            cout << "Isosceles" << '\n';
        } else {
            cout << "Scalene" << '\n';
        }
    } else {
        cout << "Error" << '\n';
    }
}