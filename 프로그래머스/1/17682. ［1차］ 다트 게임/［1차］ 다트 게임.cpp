#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(string dartResult) {
    int answer = 0;
    int temp_score = 0;
    int temp_char = 0;
    vector<int> totalArr;
    for(int i = 0; i < dartResult.size(); ++i) {
        if ((dartResult[i] >= '0') && (dartResult[i] <= '9')) {
            temp_score *= 10;
            temp_score += dartResult[i]-'0';
        }
        if ((dartResult[i] >= 'A') && (dartResult[i] <= 'Z')) {
            if (dartResult[i] == 'S') totalArr.push_back(temp_score);
            else if (dartResult[i] == 'D') totalArr.push_back(temp_score*temp_score);
            else if (dartResult[i] == 'T') totalArr.push_back(temp_score*temp_score*temp_score);
            temp_score = 0;
        }
        if (dartResult[i] == '*') {
            totalArr[totalArr.size()-1] <<= 1;
            totalArr[totalArr.size()-2] <<= 1;
        }
        if (dartResult[i] == '#') {
            totalArr[totalArr.size()-1] *= -1;
        }
    }
    
    for (int i = 0; i < totalArr.size(); ++i) {
        answer += totalArr[i];
    }
    return answer;
}