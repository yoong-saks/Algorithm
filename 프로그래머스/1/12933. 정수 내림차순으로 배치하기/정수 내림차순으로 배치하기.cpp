#include <string>
#include <vector>
#include <algorithm>

using namespace std;

long long solution(long long n) {
    long long answer = 0;
    vector <int> arr;
    while (n>0)
    {
        arr.push_back(n%10);
        n/=10;
    }
    sort(arr.rbegin(),arr.rend());
    for(int i=0;i<arr.size();i++)
    {
        answer += arr[i];
        answer *=10;
    }
    answer/=10;
    return answer;
}