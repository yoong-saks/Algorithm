#include <iostream>

using namespace std;

int main() {
    int a, b;

    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    while(1) {
        cin >> a >> b;

        if(!a && !b) {
            break;
        }
        cout << a + b << '\n';
    }
}