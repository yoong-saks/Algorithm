#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(string X, string Y) {
    string answer = "";
    
    vector<int> X_count(10,0); //string X에서 나타나는 각 숫자들의 개수
    vector<int> Y_count(10,0); //string Y에서 나타나는 각 숫자들의 개수
    for(auto c : X) {
        X_count[c-'0']++;
    }
    for(auto c : Y) {
        Y_count[c-'0']++;
    }
    for(int i = 9; i >= 0; --i) {
        if(X_count[i]&&Y_count[i]) { //만약에 X와 Y의 count값이 둘 다 존재한다면,
            for(int j = 0; j < min(X_count[i], Y_count[i]); ++j) answer.push_back(i+'0'); //X count와 Y count의 더 작은 값만큼 push_back해준다.
        }
    }
    if(answer[0] == '0') answer = "0"; //첫 번째 글자가 0이면 0이 반복될 수도 있으니, 그냥 "0"으로 대입
    else if(answer == "") answer = "-1"; //아무 글자 없으면 "-1" 대입
    return answer;
}