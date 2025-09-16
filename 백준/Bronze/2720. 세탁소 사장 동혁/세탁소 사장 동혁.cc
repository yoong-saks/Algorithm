#include <iostream>
#include <vector>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int T;
    
    cin >> T;

    while(T--) {

        int a;
        vector<int> v(4, 0);

        cin >> a;

        while(a) {
            if(a >= 25) {
                v[0]++;
                a -= 25;
                
                continue;
            }
            if(a >= 10) {
                v[1]++;
                a -= 10;

                continue;
            }
            if(a >= 5) {
                v[2]++;
                a -= 5;

                continue;
            }
            if(a >= 1) {
                v[3]++;
                a -= 1;

                continue;
            }
        }

        cout << v[0] << ' ' << v[1] << ' ' << v[2] << ' ' << v[3] << '\n';
    }
}