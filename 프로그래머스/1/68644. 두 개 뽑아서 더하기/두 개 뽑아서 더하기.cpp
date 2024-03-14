#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    vector<bool> arr(201,0);
    for(int i=0; i<numbers.size();++i) 
        for(int j=i+1; j<numbers.size();++j) 
            arr[numbers[i]+numbers[j]] = true;
    
    for(int i=0; i<arr.size();++i) 
        if(arr[i]) answer.push_back(i);
    
    return answer;
}