#include <string>
#include <vector>
using namespace std;

string solution(string s) {
    string answer = "";
    bool is_start = true;
    for(auto a : s) {
        if(a >= 'A' && a <= 'Z') {
            if(is_start) { answer += a; is_start = false; }
            else answer += (a + ('a' - 'A'));
        }
        else if(a >= 'a' && a <= 'z') {
            if(is_start) { answer += (a - ('a' - 'A')); is_start = false; }
            else answer += a;
        }
        else {
            answer += a;
            if(a == ' ') is_start = true;
            else is_start = false;
        }
    }
    return answer;
}