#include <iostream>

using namespace std;

int main() {
    int max = -2147483647;
    int loc;
    int a;

    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    for(int i = 0; i < 9; i++) {
        cin >> a;
        if(max < a) {
            max = a;
            loc = i + 1;
        }
    }

    cout << max << '\n' << loc << '\n';
    
}