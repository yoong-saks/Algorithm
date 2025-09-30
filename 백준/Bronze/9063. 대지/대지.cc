#include <iostream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int N;

    cin >> N;

    int ml, mr, mt, mb;
    ml = mb = -10001;
    mr = mt = 10001;

    for(int i = 0; i < N; i++) {
        int x, y;

        cin >> x >> y;

        if(N == 1) {
            cout << '0' << '\n';

            return 0;
        }

        if(x > ml) {
            ml = x;
        }
        if(x < mr) {
            mr = x;
        }
        if(y > mb) {
            mb = y;
        }
        if(y < mt) {
            mt = y;
        }
    }

    cout << (mr - ml) * (mt - mb) << '\n';
}