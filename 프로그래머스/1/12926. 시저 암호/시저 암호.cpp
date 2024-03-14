#include <string>
#include <vector>

using namespace std;

string solution(string s, int n) {
    for (auto& a : s) {
        if (a!=' ') {
            if ((a<='z'&&(a+n)>'z')||(a<='Z'&&(a+n)>'Z')) a = a + n - ('z'-'a'+1);
            else a = a + n;
        }
    }
    return s;
}