#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<int> ingredient) {
    int answer = 0;
    vector<int> stack;
    for(int i = 0; i < ingredient.size(); ++i) {
        stack.push_back(ingredient[i]);
        if(stack.size() >= 4) {
            if(stack[stack.size()-4]*1000+stack[stack.size()-3]*100+stack[stack.size()-2]*10+stack[stack.size()-1] == 1231) {
                for(int j = 0; j < 4; j++) stack.pop_back();
                answer++;
            }
        }
    }
    return answer;
}