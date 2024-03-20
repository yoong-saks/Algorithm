#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(string s) {
    int answer = 0;
    char temp = s[0];
    int sum = 0;
    int x = 0;
    int y = 0;
    for(char c : s) {
        if(temp == c) x++;
        else y++;
        if(x==y) {
            answer++;
            sum += (x+y);
            temp = s[sum];
            x = y = 0;
        }
    }
    if(x!=y) answer++;
    return answer;
}