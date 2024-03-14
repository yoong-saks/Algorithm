using namespace std;

long long solution(int pri, int money, int count)
{
    long long answer = 0;
    for (int i=1; i<=count; ++i) answer += pri*i;
    
    if(answer>money) return answer-money;
    else return 0;
}