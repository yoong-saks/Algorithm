#include <vector>
#include <iostream>
using namespace std;

int solution(vector<int> nums)
{
    int answer = 0;
    vector<int> cmp;
    cmp.push_back(nums[0]);
    
    for(int i = 1; i<nums.size(); ++i) {
        bool duplicated = false;
        for(int j=0; j<cmp.size(); ++j) 
            if(nums[i] == cmp[j]) duplicated = true;

        if(!duplicated) { cmp.push_back(nums[i]); }
    }
    
    for(int i=0; i<cmp.size();++i) {
        cout<<cmp[i]<<endl;
    }
    if(cmp.size()>(nums.size()/2)) return (nums.size()/2);
    else return cmp.size();
}