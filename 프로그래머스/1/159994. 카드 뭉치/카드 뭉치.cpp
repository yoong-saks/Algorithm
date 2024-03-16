#include <string>
#include <vector>

using namespace std;

string solution(vector<string> cards1, vector<string> cards2, vector<string> goal) {
    bool answer = true;
    int one_idx = 0;
    int two_idx = 0;
    for(int i =0; i<goal.size();++i) {
        if(one_idx < cards1.size() &&goal[i] == cards1[one_idx]) one_idx+=1;
        else if(two_idx < cards2.size() && goal[i] == cards2[two_idx]) two_idx+=1;
        else answer = false;
    } 
    return answer?"Yes": "No";
}