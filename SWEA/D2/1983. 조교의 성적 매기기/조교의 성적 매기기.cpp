#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

string grade[10] = {"A+", "A0", "A-", "B+", "B0", "B-", "C+", "C0", "C-", "D0"};

int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        int n, k;

        cin >> n >> k;

        vector<int> v;
        int k_score = 0;

        for(int i = 1; i <= n; ++i) {
            int a, b, c;

            cin >> a >> b >> c;

            if(i == k) k_score = a * 35 + b * 45 + c * 20;

            v.push_back(a * 35 + b * 45 + c * 20);
        }

        sort(v.rbegin(), v.rend());

        int k_rank = 0;

        k_rank = find(v.begin(), v.end(), k_score) - v.begin();

        int quota = n / 10;

        cout << '#' << t << ' ' << grade[k_rank / quota] << '\n';

    }
}