#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int a, sum = 0;
    vector<float> v;

    cin >> a;

    while(a--) {
        float x;

        cin >> x;

        v.push_back(x);
        sum += x;
    }

    sort(v.begin(), v.end());

    cout << sum / v.back() * 100 / v.size() << '\n';
}