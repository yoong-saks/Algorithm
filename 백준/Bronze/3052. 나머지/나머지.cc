#include <iostream>
#include <map>

using namespace std;

int main() {

    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    map<int, int> m;

    for(int i = 0; i < 10; i++) {
        int x;

        cin >> x;

        m.insert({x % 42, 1});
    }

    cout << m.size() << '\n';
}