#include <vector>
#include <iostream>
#include <cstring>
using namespace std;

bool arr[3001];
int solution(vector<int> nums) {
    int answer = 0;
    memset(arr, true, sizeof(arr));
    
    for(int i = 2; i < sizeof(arr); ++i) {
        if (!arr[i]) continue;
        for (int j = i*2; j <= sizeof(arr); j += i) {
            arr[j] = false;
        }
    }
    
    for(int i = 0; i < nums.size(); ++i) {
        for(int j = i+1; j < nums.size(); ++j) {
            for(int k = j+1; k < nums.size(); ++k) {
                if(arr[nums[i]+nums[j]+nums[k]]) answer++;
            }
        }
    }

    return answer;
}