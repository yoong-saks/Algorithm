#include <string>
#include <vector>
#include <sstream>
#include <iostream>
#include <unordered_map>
using namespace std;

int solution(vector<string> friends, vector<string> gifts) {
    int answer = 0;
    vector<vector<int>> gift_matrix(friends.size(),vector<int>(friends.size(),0));
    unordered_map<string,int> name_idx;
    vector<int> gift_idx(friends.size(),0);
    for(int i = 0; i < friends.size(); ++i) {
        name_idx[friends[i]] = i;
    }
    for(auto s : gifts) {
        string s1, s2;
        istringstream iss(s);
        iss >> s1 >> s2;
        gift_matrix[name_idx[s1]][name_idx[s2]]++;
        gift_idx[name_idx[s1]] += 1;
        gift_idx[name_idx[s2]] -= 1;
    }
    int max_gift = 0;
    for(int i = 0; i < gift_matrix.size(); ++i) {
        int your_gift = 0;
        for(int j = 0; j < gift_matrix[i].size(); ++j) {
            if(i != j) {
                if(gift_matrix[i][j] == gift_matrix[j][i]) {
                    if(gift_idx[i] > gift_idx[j]) your_gift++;
                }
                else if(gift_matrix[i][j] > gift_matrix[j][i]) {
                    your_gift++;
                }
            }
        }
        if (your_gift > max_gift) max_gift = your_gift;
    }
    answer = max_gift;
    return answer;
}