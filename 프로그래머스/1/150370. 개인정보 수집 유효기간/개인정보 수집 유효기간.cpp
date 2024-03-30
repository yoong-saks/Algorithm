#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(string today, vector<string> terms, vector<string> privacies) {
    vector<int> answer;
    vector<string> dates(privacies.size(), "");
    vector<int> termalpha_idx(26, 0);
    
    for (int i = 0; i < terms.size(); ++i) { //term_idx
        termalpha_idx[terms[i][0]-'A'] = stoi(terms[i].substr(2));
    }
    for(int i = 0; i < privacies.size(); ++i) {
        int month = stoi(privacies[i].substr(5,2))+termalpha_idx[privacies[i][privacies[i].size()-1]-'A'];
        int year = stoi(privacies[i].substr(2,2));
        while (month > 12) {
            month -= 12;
            year++;
        }
        privacies[i][2] = year/10+'0';
        privacies[i][3] = year%10+'0';
        privacies[i][5] = month/10+'0';
        privacies[i][6] = month%10+'0';
        
        dates[i].append(privacies[i],0,10);
        cout << dates[i] << endl;
        if (dates[i] <= today) answer.push_back(i+1);
    }
    return answer;
}