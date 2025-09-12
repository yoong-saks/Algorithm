#include <iostream>
#include <vector>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int max = -1;
    int a;
    int xidx, yidx;
    for(int i = 0; i < 9; i++) {
        for(int j = 0; j < 9; j++) {
            cin >> a;
            if(a > max) {
                max = a;
                xidx = i + 1;
                yidx = j + 1;
            }
        }
    }
    
    cout << max << '\n' << xidx << ' ' << yidx << '\n';
}