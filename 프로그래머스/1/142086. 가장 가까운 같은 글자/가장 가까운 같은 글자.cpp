#include <string>
#include <vector>

using namespace std;

vector<int> solution(string s) {
    vector<int> answer;
    vector<int> atoz_arr('z'-'a'+1,-1);
    
    for (int i=0; i<s.size(); ++i) {
        if(atoz_arr[s[i]-'a'] == -1) answer.push_back(atoz_arr[s[i]-'a']);
        else answer.push_back(i-atoz_arr[s[i]-'a']);
        atoz_arr[s[i]-'a'] = i;
    }
    return answer;
}