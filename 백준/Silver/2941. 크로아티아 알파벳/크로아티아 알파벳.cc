#include <iostream>
#include <vector>
#include <string>
using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    string s;
    vector<string> v = {"dz=", "c=", "c-", "d-", "lj", "nj", "s=", "z="};
    
    getline(cin, s);

    int ans = s.size();


    for(string fs : v) {
        while(1) {
            size_t pos = s.find(fs);

            if(pos == string::npos) {
                break;
            }

            ans--;

            if(fs == "dz=") {
                ans--;
            }
            s.replace(pos, fs.size(), "1");
        }
    }

    cout << ans << '\n';
}