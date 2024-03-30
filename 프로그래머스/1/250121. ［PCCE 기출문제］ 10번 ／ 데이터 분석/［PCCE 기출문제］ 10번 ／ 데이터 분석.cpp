#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

vector<string> ext_arr{"code","date","maximum","remain"};
int ext_idx = -1;
int sort_idx = -1;

bool compare(vector<int> p1,vector<int> p2) {
    return p1[sort_idx] < p2[sort_idx];
}
vector<vector<int>> solution(vector<vector<int>> data, string ext, int val_ext, string sort_by) {
    vector<vector<int>> answer;
    
    for (int i = 0; i < ext_arr.size(); ++i) {
        if(ext_arr[i] == ext) ext_idx = i;
        if(ext_arr[i] == sort_by) sort_idx = i;
    }
    for (auto x : data) {
        if(x[ext_idx] < val_ext) answer.push_back(x);
    }
    
    sort(answer.begin(), answer.end(), compare);
    return answer;
}