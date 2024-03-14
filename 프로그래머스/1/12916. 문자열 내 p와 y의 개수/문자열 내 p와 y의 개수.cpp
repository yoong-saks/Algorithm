#include <string>
#include <iostream>
using namespace std;

bool solution(string s)
{
    bool answer = true;
    int pc, py;
    pc = py = 0;
    for(auto c:s)
    {
        if (c == 'p'||c=='P')
        {
            pc +=1;
        }
        else if(c == 'y'||c=='Y')
        {
            py +=1;
        }
    }
    if (pc != py) answer = false;
    return answer;
}