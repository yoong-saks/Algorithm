#include <string>
#include <vector>
using namespace std;

string solution(string s) {
    int di = 'a' - 'A';
    bool sig = true;
    for(auto &a : s) {
        if (a != ' ') {
            if (a>='a'&&a<='z'&&sig==true) {
                a-=di;
                sig=false;
            }
            else if (a>='A'&&a<='Z') {
                if (sig==true) sig=false;
                else (a+=di, sig = true);
            }
            else sig = true;
        }
        else sig=true;
    }
    return s;
}