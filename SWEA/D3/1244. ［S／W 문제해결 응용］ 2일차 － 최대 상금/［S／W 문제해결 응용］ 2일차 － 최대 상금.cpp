#include <iostream>
#include <cstring>

using namespace std;

int ans, K;

bool dp[11][1000000];

void dfs(string s, int depth) {
    if(depth == K) {
        if(stoi(s) > ans) {
            ans = stoi(s);
        }
        return;
    }

    if(dp[depth][stoi(s)]) {
        return;
    }
    
    dp[depth][stoi(s)] = true;

    for(int i = 0; i < s.size(); ++i) {
        for(int j = i + 1; j < s.size(); ++j) {
            swap(s[i], s[j]);

            dfs(s, depth + 1);

            swap(s[i], s[j]);
        }
    }
}

int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        string s;
        ans = 0;
        memset(dp, 0, sizeof(dp));

        cin >> s >> K;
        
        dfs(s, 0);

        cout << '#' << t << ' ' << ans << '\n';
    }
}