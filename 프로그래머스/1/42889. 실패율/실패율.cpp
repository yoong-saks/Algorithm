#include <string>
#include <vector>

using namespace std;

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<int> arr(N+1, 0);
    vector<float> fail_rate(N+1, 0);
    for(int i = 0; i < stages.size(); ++i) {
        for(int j = 1; j <= N; ++j) 
            if(stages[i] == j) arr[j] = arr[j] + 1;
    } 
    
    int remained = stages.size();
    for(int i = 0; i < arr.size(); ++i) {
        if(arr[i]) {
            fail_rate[i] = (float)arr[i] / remained;
            remained -= arr[i];
        }
    }

    for(int i = 0; i < N; i++) {
        int max_idx = fail_rate.size()-1;
        for(int j = fail_rate.size()-1; j >= 1; --j) {
            if (fail_rate[j]>=fail_rate[max_idx]) max_idx = j;
        }
        if(fail_rate[max_idx]) {
            answer.push_back(max_idx);
            fail_rate[max_idx] = -1;
        }
    }
    
    for(int i = 1; i < fail_rate.size(); ++i) {
        if (fail_rate[i] == 0) answer.push_back(i);
    }
    return answer;
}