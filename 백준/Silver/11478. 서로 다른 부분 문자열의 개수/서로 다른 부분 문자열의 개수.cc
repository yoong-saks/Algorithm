#include <iostream>
#include <set>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    string s;
    set<string> s1;
    
    cin >> s;

    for(int i = 1; i <= s.size(); i++) {
        for(int j = 0; j + i <= s.size(); j++) {
            s1.insert(s.substr(j, i));
        }
    }

    cout << s1.size() << '\n';

}