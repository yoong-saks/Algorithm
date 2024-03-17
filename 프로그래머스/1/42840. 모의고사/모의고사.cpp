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
    cout << supo_one[4] <<endl;
    for(int i=0;i<10000; ++i) {
        if(answers[i%5] == supo_one[i%supo_one.size()]) answer_cnt[0]=answer_cnt[0]+1;
        if(answers[i%5] == supo_two[i%supo_two.size()]) answer_cnt[1]=answer_cnt[1]+1;
        if(answers[i%5] == supo_thr[i%supo_thr.size()]) answer_cnt[2]=answer_cnt[2]+1;
    }
    cout << answer_cnt[0] << endl;
    cout << answer_cnt[1] << endl;
    cout << answer_cnt[2] << endl;
    return answer;
}