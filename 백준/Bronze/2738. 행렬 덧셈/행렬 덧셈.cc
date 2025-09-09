#include <iostream>
#include <vector>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int n, m;
    cin >> n >> m;


    vector<vector<int>> v(n, vector<int>(m, 0));

    for(int i = 0; i < 2; i++) {
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int input;
                cin >> input;
                v[i][j] += input;
            }
        }
    }


    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            cout << v[i][j] << ' ';
        }
        cout << '\n';
    }
}