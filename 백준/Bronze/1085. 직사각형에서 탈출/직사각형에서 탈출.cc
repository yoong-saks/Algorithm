#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int x, y, w, h;

    cin >> x >> y >> w >> h;

    int min = 1001;

    if(x < min) {
        min = x;
    }
    if(y < min) {
        min = y;
    }
    if(w - x < min) {
        min = w - x;
    }
    if(h - y < min) {
        min = h - y;
    }

    cout << min << '\n';
}