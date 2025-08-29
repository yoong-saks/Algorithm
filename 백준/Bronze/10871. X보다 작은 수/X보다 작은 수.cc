#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    vector<int> v;
    int a, b;
    string str = "";

    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> a >> b;

    for(int i = 0; i < a; i++) {
        int t;
        cin >> t;

        if(t < b) {
            str += to_string(t);
            str += " ";
        }
    }

    cout << str << '\n';
}