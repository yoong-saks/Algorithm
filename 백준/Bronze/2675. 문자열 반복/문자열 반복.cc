#include <iostream>
#include <vector>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int a;


    cin >> a;

    while(a--) {
        int b;
        string s;

        cin >> b;
        cin >> s;

        for(char c : s) {
            for(int i = 0; i < b; i++) {
                cout << c;
            }
        }
        cout << '\n';
    }
    
}