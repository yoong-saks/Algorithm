#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int min = 1000000;
    int max = -1000000;

    int a;

    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> a;

    while(a--) {
        int t;
        cin >> t;

        if(t < min) {
            min = t;
        }
        if(t > max) {
            max = t;
        }
    }

    cout << min << " " << max << '\n';
}