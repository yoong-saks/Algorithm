#include<string>
#include <iostream>
#include <vector>

using namespace std;

bool solution(string s)
{
    bool answer = true;
    vector<char> stack;
    for(auto c : s) {
        if(c == '(') {
            stack.push_back(c);
        }
        else {
            if (stack.empty()) return false;
            else {
                if(stack[stack.size()-1] == '(') stack.pop_back();
            }
        }
    }
    if(!stack.empty()) answer = false;
    
    return answer;
}