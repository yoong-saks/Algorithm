#include <iostream>
#include <vector>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N;
    vector<int> v;

    cin >> N;

    while(N--) {
        int a;
        cin >> a;
        switch (a) {
        case 1:
            int x;
            cin >> x;

            v.push_back(x);
            break;
        case 2:
            if(v.empty()) {
                cout << -1 << '\n';
                break;
            }

            cout << v[v.size() - 1] << '\n';
            v.pop_back();
            break;
        case 3:
            cout << v.size() << '\n';
            break;
        case 4:
            if(v.empty()) {
                cout << 1 << '\n';
                break;
            }
            cout << 0 << '\n';
            break;
        case 5:
            if(v.empty()) {
                cout << -1 << '\n';
                break;
            }

            cout << v[v.size() - 1] << '\n';
            break;
        }
    }
}