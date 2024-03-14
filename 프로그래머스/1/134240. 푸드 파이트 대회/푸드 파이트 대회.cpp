#include <string>
#include <vector>

using namespace std;

string solution(vector<int> food) {
    string answer = "";
    for(int i = 1; i<food.size(); ++i) {
        for(int j = 1; j<=(food[i]/2); ++j) answer.push_back(i+'0');
    }
    
    for(int i = 1; i<=food[0]; ++i) answer.push_back('0');
    
    for(int i = 1; i<food.size(); ++i) {
        for(int j = 1; j<=(food[food.size()-i]/2); ++j) answer.push_back(food.size()-i+'0');
    }
    return answer;
}