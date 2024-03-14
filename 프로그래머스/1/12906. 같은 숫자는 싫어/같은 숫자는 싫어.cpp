#include <vector>
#include <iostream>

using namespace std;

vector<int> solution(vector<int> arr) 
{
    vector<int> answer;

    answer.push_back(arr[0]);
    
    int i = 0;
    for(auto c : arr)
    {
        if (c!=answer[i]) {
            answer.push_back(c);
            ++i;
        }
    }

    return answer;
}