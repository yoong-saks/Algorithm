#include <string>
#include <vector>
#include <iostream>
#include <unordered_map> // 드디어 언오더드 맵을 내가 써보는구나 드디어 !

using namespace std;

string solution(vector<string> participant, vector<string> completion) {
    string answer = "";
    unordered_map<string,int> um;
    for (string s : participant) um[s]++;
    for (string s : completion) um[s]--;
    for (auto elem : um) {
        if(elem.second) answer = elem.first; 
    }
    return answer;
}