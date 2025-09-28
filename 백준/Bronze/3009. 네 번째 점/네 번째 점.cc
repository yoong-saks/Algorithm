#include <iostream>
#include <vector>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int x, y;
    vector<int> isuniquex(1001, 0);
    vector<int> isuniquey(1001, 0);

    for(int i = 0; i < 3; i++) {
        cin >> x >> y;

        isuniquex[x]++;
        isuniquey[y]++;
    }
    
    for(int i = 1; i < 1001; i++) {
        if(isuniquex[i] == 1) {
            cout << i << ' ';
        }
    }
    for(int i = 1; i < 1001; i++) {
        if(isuniquey[i] == 1) {
            cout << i << '\n';
        }
    }
}