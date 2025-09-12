#include <iostream>
#include <vector>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    vector<string> v(5);
    int max_size = 0;

    for(int i = 0; i < 5; i++) {
        string s;
        cin >> s;
        v[i] = s;
        
        if(max_size < s.size()) {
            max_size = s.size();
        }
    }

    for(int i = 0; i < max_size; i++) {
        for(int j = 0; j < 5; j++) {
            if(i >= v[j].size()) continue;

            cout << v[j][i];
        }
    }

    cout << '\n';
}