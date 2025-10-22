#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    vector<string> v;

    int a;

    cin >> a;

    for(int i = 0; i < a; i++) {
        string s;

        cin >> s;

        v.push_back(s);
    }

    sort(v.begin(), v.end(), [](const string& a, const string& b) {
        if(a.size() == b.size()) {
            return a < b;
        }

        return a.size() < b.size();
    });

    v.erase(unique(v.begin(), v.end()), v.end());

    for(const string& s : v) {
        cout << s << '\n';
    }
}