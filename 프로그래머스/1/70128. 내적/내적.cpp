#include <string>
#include <vector>

using namespace std;

int solution(vector<int> a, vector<int> b) {
    int answer = 0;
    if(a.size()==b.size()) {
        for(int i = 0; i<a.size(); i++)
        {
            answer += a[i]*b[i];
        }
    }
    else return -1;
    return answer;
}