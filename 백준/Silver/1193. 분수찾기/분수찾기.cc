#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int a;
    int i = 1;

    cin >> a;

    while(a > i) {
        a -= i;
        i++;
    }

    if((i % 2) == 0) {
        cout << a << '/' << i - a + 1 << '\n';
    } else {
        cout << i - a + 1 << '/' << a << '\n';
    }
    
}
