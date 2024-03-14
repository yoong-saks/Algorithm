#include <string>
#include <vector>

using namespace std;

long long solution(int a, int b) {
    long long answer = 0;
    
    for (int n=((a>b)?b:a);n<=((a>b)?a:b);n++) answer += n;
    return answer;
}