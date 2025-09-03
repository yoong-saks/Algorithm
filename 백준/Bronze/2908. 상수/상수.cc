#include <iostream>
#include <vector>
#include <sstream>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    
    string s1, s2;

    cin >> s1 >> s2;

    char t;

    t = s1[0];
    s1[0] = s1[2];
    s1[2] = t;

    t = s2[0];
    s2[0] = s2[2];
    s2[2] = t;

    if(stoi(s1) > stoi(s2)) {
        cout << s1 << '\n';
    } else {
        cout << s2 << '\n';
    }

    
}