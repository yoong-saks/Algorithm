#include <string>
#include <vector>

using namespace std;

vector<string> solution(int n, vector<int> arr1, vector<int> arr2) {
    vector<string> answer(n,"");

    for(int i=0;i<n;++i) {
        for(int j=n-1;j>=0;--j) {
            if((arr1[i] | arr2[i])>>j & 0b1) answer[i].push_back('#');
            else answer[i].push_back(' ');
        }
    }
    
    return answer;
}