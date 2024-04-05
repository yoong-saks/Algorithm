#include <string>
#include <vector>
#include <unordered_map>
#include <iostream>
#include <set>
using namespace std;

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer(id_list.size(), 0);
    unordered_map<string,vector<int>> m;
    unordered_map<string,int> name_index;
    vector<int> cnt_report(id_list.size(), 0);
    set<string> s1(report.begin(), report.end());
    vector<string> new_report(s1.begin(), s1.end());
    int i = 0;
    for(auto s : id_list) {
        m[s] = vector<int>(id_list.size(),0);
        name_index[s] = i++;
    }
    cout << name_index["ryan"] << endl;
    for(auto s : new_report) {
        string shooter = s.substr(0,s.find(' '));
        string target = s.substr(s.find(' ')+1);
        m[shooter][name_index[target]]++;
    }
    
    for(auto s : id_list) {
        for(int j = 0; j < m[s].size(); ++j) {
            if(m[s][j]) cnt_report[j]++;
        }
    }
    
    for(auto s : new_report) {
        string shooter = s.substr(0,s.find(' '));
        string target = s.substr(s.find(' ')+1);
        if (cnt_report[name_index[target]] >= k) {
            answer[name_index[shooter]]++;
        }
    }
    return answer;
}