#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N;
    vector<int> v;

    cin >> N;

    for(int i = 0; i < N; i++) {
        int a;

        cin >> a;

        v.push_back(a);
    }

    sort(v.begin(), v.end());

    for (int a : v) {
        cout << a << '\n';
    }
}