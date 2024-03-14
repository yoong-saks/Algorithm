#include <string>
#include <vector>

using namespace std;

bool solution(int x) {
    bool answer = true;
    int radix_sum = 0;
    int temp = x;
    while (temp>0)
    {
        radix_sum += temp%10;
        temp/=10;
    }
    if (x%radix_sum == 0) answer = true;
    else answer = false;
    return answer;
}