#include <iostream>
#include <vector>

using namespace std;

vector<int> graph[101];
bool visited[101];
int ans;

void dfs(int x) {
    visited[x] = true;
    ans++;

    for(int i = 0; i < graph[x].size(); ++i) {
        if(!visited[graph[x][i]]) {
            dfs(graph[x][i]);
        }
    }
}

int main() {
    int V, E;

    cin >> V >> E;

    for(int i = 0; i < E; ++i) {
        int u, v;

        cin >> u >> v;

        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    dfs(1);

    cout << ans - 1 << endl;
}