#include <iostream>
#include <vector>
#include <string>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    vector<int> v;

    for(int i = 666; i < INT32_MAX; i++) {
        if(to_string(i).find("666") != string::npos) {
            v.push_back(i);

            if(v.size() > 10000) {
                break;
            }
        }
    }

    int a;

    cin >> a;

    cout << v[a - 1] << '\n';
}