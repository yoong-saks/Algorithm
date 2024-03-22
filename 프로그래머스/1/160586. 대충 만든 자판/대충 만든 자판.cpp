#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer(targets.size(),0);
    vector<int> least_index(26,101);
    for (int i = 0; i < keymap.size(); ++i) {
        for (int j = 0; j < keymap[i].size(); ++j) {
            if (least_index[keymap[i][j]-'A'] > j) least_index[keymap[i][j]-'A'] = j;
        }
    }
    
    for(int i = 0; i < targets.size(); ++i) {
        for(char c : targets[i]) {
            if(least_index[c-'A'] == 101) { answer[i] = -1; break; }
            else if(least_index[c-'A'] != 101) answer[i] += least_index[c-'A']+1;
        }
    }
    return answer;
}