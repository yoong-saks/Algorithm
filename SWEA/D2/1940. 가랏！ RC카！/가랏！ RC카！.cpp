#include <iostream>

using namespace std;

int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        int n;
        int velocity = 0;
        int ans = 0;
        
        cin >> n;

        for(int i = 0; i < n; ++ i) {
            int comm;

            cin >> comm;

            if(comm == 1) {
                int accel;

                cin >> accel;

                velocity += accel;
            }
            if(comm == 2) {
                int slow;

                cin >> slow;

                velocity -= slow;
                velocity < 0 ? velocity = 0 : velocity;
            }

            ans += velocity;
        }

        cout << '#' << t << ' ' << ans << '\n';
    }
}