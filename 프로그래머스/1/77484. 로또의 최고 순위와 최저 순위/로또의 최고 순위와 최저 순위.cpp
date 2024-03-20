#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> lottos, vector<int> win_nums) {
    vector<int> answer;
    int ranking = 0, cnt = 0;
    for(int i = 0; i < lottos.size(); ++i) {
        if (lottos[i] == 0) cnt++;
        else {
            for(int j = 0; j < win_nums.size(); ++j) {
                if(lottos[i] == win_nums[j]) ranking++;
            }
        }
    }
    if(7 - ranking - cnt >= 6) answer.push_back(6);
    else answer.push_back(7 - ranking - cnt);
    if (7-ranking >= 6) answer.push_back(6);
    else answer.push_back(7 - ranking);

    
    return answer;
}