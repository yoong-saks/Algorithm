#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> strlist) {
    vector<int> answer;
    for(auto v : strlist)
    {
        answer.push_back(v.size());
    }
    return answer;
}