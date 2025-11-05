#include <iostream>
#include <vector>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    int N;
    vector<int> v;
    int sum = 0;

    cin >> N;

    while(N--) {
        int a;

        cin >> a;

        if(a == 0 && v.size() != 0) {
            v.pop_back();
            continue;
        }

        v.push_back(a);
    }

    for(int i = 0; i < v.size(); i++) {
        sum += v[i];
    }

    cout << sum << '\n';
}