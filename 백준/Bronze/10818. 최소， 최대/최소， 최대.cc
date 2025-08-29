#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    vector<int> v;
    int a;

    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    cin >> a;

    for(int i = 0; i < a; i++) {
        int t;
        cin >> t;
        
        v.push_back(t);
    }

    sort(v.begin(), v.end());

    cout << v.front() << " " << v.back() << '\n';
}