#include <string>
#include <vector>
#include <cmath>

using namespace std;

int solution(int n) {
    int answer = 0;
    vector<int> v;
    
    while(n!=0) {
        v.push_back(n%3);
        n/=3;
    }
    
    for(int i = 0; i<v.size(); ++i) {
        answer += (v[v.size()-1-i])*pow(3,i);
    }
    return answer;
}