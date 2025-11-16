#include <iostream>
#include <vector>
#include <algorithm>
#include <numeric>

using namespace std;

int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        vector<int> v;
        
        for(int i = 0; i < 10; ++i) {
            int tmp;

            cin >> tmp;

            v.push_back(tmp);
        }

        sort(v.begin(), v.end());

        double sum = accumulate(v.begin() + 1, v.end() - 1, 0);

        cout << '#' << t << ' ' << (int)((sum / (v.size() - 2)) + (0.5)) << '\n';
    }
}