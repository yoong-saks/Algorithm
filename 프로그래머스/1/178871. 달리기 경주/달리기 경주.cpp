#include <string>
#include <vector>
#include <map>
#include <unordered_map>
#include <iostream>
using namespace std;

vector<string> solution(vector<string> players, vector<string> callings) {
    vector<string> answer;
    map<int,string> c_rank;
    unordered_map<string, int> name_rank;

    int i = 0;
    for(auto s : players) {
        c_rank[++i] = s;
        name_rank[s] = i;
    }

    string temp = "";
    for(auto s : callings) {
        temp = c_rank[name_rank[s]-1];
        c_rank[name_rank[s]-1] = s;
        c_rank[name_rank[s]] = temp;
        name_rank[s] -= 1;
        name_rank[temp] += 1;
    }

    for(auto iter = c_rank.begin(); iter != c_rank.end(); ++iter) {
        answer.push_back(iter->second);
    }
    
    return answer;
}