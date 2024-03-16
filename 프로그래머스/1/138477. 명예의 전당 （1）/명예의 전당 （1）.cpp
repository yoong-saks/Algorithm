#include <string>
#include <vector>
#include <queue>
#include <iostream>

using namespace std;

vector<int> solution(int k, vector<int> score) {
	// priority_queue<int> q;	// 내림차순 
	// priority_queue<int, vector<int>, less<int> > q;	// 내림차순
	priority_queue<int, vector<int>, greater<int> > pq;
    vector<int> answer;
    for(int i=0; i<score.size(); ++i) {
        pq.push(score[i]);
        (pq.size()<=k)?answer.push_back(pq.top()):(pq.pop(),answer.push_back(pq.top()));
    }

    return answer;
}