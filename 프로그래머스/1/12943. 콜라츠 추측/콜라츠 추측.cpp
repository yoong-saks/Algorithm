#include <string>
#include <vector>

using namespace std;

int solution(int num) {
    int answer = 0;
    long long n = num;
    while (1)
    {
        if(n==1) break;
        if(n%2==0) n/=2;
        else n = (n*3)+1;
        answer = answer +1;
    }
    if(answer > 500) answer = -1;
    return answer;
}