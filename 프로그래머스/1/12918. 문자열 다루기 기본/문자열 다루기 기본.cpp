#include <string>
#include <vector>
#include <iostream>

using namespace std;

bool solution(string s) {
    bool answer = false;
    if ((int)s.size() == 4 || (int)s.size() == 6) 
    {
        for(int i=0; i<s.size();++i)
        {
            if(s[i]>'9') { answer = false; break; }
            else { answer = true; }
        }
    }
    return answer;
}