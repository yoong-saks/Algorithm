#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string X, string Y) {
    string answer = "";
    
    vector<int> X_count(10,0);
    vector<int> Y_count(10,0);
    for(auto c : X) {
        X_count[c-'0']++;
    }
    for(auto c : Y) {
        Y_count[c-'0']++;
    }
    for(int i = 9; i >= 0; --i) {
        if(X_count[i]&&Y_count[i]) {
            for(int j = 0; j < min(X_count[i], Y_count[i]); ++j) answer.push_back(i+'0');
        }
    }
    if(answer[0] == '0') answer = "0";
    else if(answer == "") answer = "-1";
    return answer;
}