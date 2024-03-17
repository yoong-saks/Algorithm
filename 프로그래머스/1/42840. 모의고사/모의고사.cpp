#include <string>
#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> answers) {
    vector<int> answer;
    vector<int> answer_cnt(3,0);
    vector<int> supo_one {1,2,3,4,5};
    vector<int> supo_two {2,1,2,3,2,4,2,5};
    vector<int> supo_thr {3,3,1,1,2,2,4,4,5,5};
    for(int i=0;i<answers.size(); ++i) {
        if(answers[i%answers.size()] == supo_one[i%supo_one.size()]) answer_cnt[0]=answer_cnt[0]+1;
        if(answers[i%answers.size()] == supo_two[i%supo_two.size()]) answer_cnt[1]=answer_cnt[1]+1;
        if(answers[i%answers.size()] == supo_thr[i%supo_thr.size()]) answer_cnt[2]=answer_cnt[2]+1;
    }
    int max = 0;
    
    for (int i=0;i<answer_cnt.size();++i) {
        if (max<answer_cnt[i]) max = answer_cnt[i];
    }
    for (int i=0;i<answer_cnt.size();++i) {
        if (max == answer_cnt[i]) answer.push_back(i+1);
    }
    
    return answer;
}