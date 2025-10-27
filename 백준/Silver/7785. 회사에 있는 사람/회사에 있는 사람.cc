#include <iostream>
#include <set>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int n;
    set<string> s;

    cin >> n;

    for(int i = 0; i < n; i++) {
        string s1, s2;

        cin >> s1 >> s2;

        if(s2 == "enter") {
            s.insert(s1);
            continue;
        }
        if(s2 == "leave") {
            s.erase(s.find(s1));
            continue;
        }
    }

    for(auto iter = s.rbegin(); iter != s.rend(); iter++) {
        cout << *iter << '\n';
    }
}