#include <iostream>
#include <vector>
#include <algorithm>
#include <cstring>
#include <queue>

using namespace std;

int N, M, V;
vector<int> graph[1001];
bool visited[1001];

void dfs(int x) {
    visited[x] = true;

    cout << x << ' ';
    
    for(int i = 0; i < graph[x].size(); ++i) {
        if(!visited[graph[x][i]]) {
            dfs(graph[x][i]);
        }
    }
}

void bfs(int x) {
    queue<int> q;

    q.push(x);
    visited[x] = true;

    while(!q.empty()) {
        int cur = q.front();
        q.pop();

        cout << cur << ' ';

        for(int i = 0; i < graph[cur].size(); ++i) {
            if(!visited[graph[cur][i]]) {
                q.push(graph[cur][i]);
                visited[graph[cur][i]] = true;
            }
        }
    }
}

int main() {
    cin >> N >> M >> V;

    for(int i = 0; i < M; ++i) {
        int u, v;
        cin >> u >> v;

        graph[u].push_back(v);
        graph[v].push_back(u);
    }

    for(int i = 1; i <= N; ++i) {
        sort(graph[i].begin(), graph[i].end());
    }

    dfs(V);

    cout << endl;
    memset(visited, 0, sizeof(visited));

    bfs(V);
    cout << endl;

    return 0;
}