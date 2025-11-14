#include <iostream>
#include <vector>

using namespace std;

int n;

int main() {
    cin >> n;

    for(int i = 1; i <= n; ++i) {
        int x = i;
        bool flag = 0;

        while(x) {
            if(x % 10 != 0 && (x % 10) % 3 == 0) {
                cout << '-';
                flag = 1;
            }
            x /= 10;
        }

        if(!flag) {
            cout << i;
        }

        cout << ' ';
    }
    cout << '\n';
}