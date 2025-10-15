#include <iostream>
#include <vector>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int a;

    cin >> a;

    vector<bool> v(2001, 0);
    int max_input = -1001;

    for(int i = 0; i < a; i++) {
        int usr_input;

        cin >> usr_input;

        v[usr_input + 1000] = 1;
        if(usr_input > max_input) {
            max_input = usr_input;
        }
    }

    for(int i = 0; i <= max_input + 1000; i++) {
        if(v[i] == 1) {
            cout << i - 1000 << '\n';
        }
    }
}