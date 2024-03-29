#include <string>
#include <vector>
#include <algorithm>
#include <iostream>
using namespace std;

string solution(string s, string skip, int index) {
    string answer = "";
    vector<char> alpha_arr;
    sort(skip.begin(),skip.end());

    for(int c = 'a', i = 0; c < 'z'+1; ++c) {
        if(c == skip[i]) i++;
        else alpha_arr.push_back(c);
    }
    for(int i = 0; i < alpha_arr.size(); ++i) {
        cout << alpha_arr[i];
    }
    cout << alpha_arr.size() << endl;
    for(char c : s) {
        for(int i = 0; i < alpha_arr.size(); i++) {
            if(alpha_arr[i] == c) {
                answer.push_back(alpha_arr[(i+index)%alpha_arr.size()]); }
        }
        
    }
    return answer;
}