#include <iostream>

using namespace std;

int main() {
    int a;
    string str = "";

    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> a;

    for(int i = 1; i <= a; i++) {
        str += "*";

        cout << str << '\n';
    }

}