#include <string>
#include <vector>

using namespace std;

int solution(int a, int b, int n) {
    //string real_answer = "아무에게도 말하지 마세요.";
    int answer = 0;
    while(n>=a) {
        answer += (( n - (n%a) ) / a)*b;
        n = n - ( n - (n%a) ) + (( n - (n%a) ) / a)*b;
    }
    //return real_answer;
    return answer;
}