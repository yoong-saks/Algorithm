#include <string>
#include <vector>

using namespace std;

double solution(vector<int> numbers) {
    int len = numbers.size();
    double sum = 0;
    for (int i=0;i<len;i++)
    {
        sum += numbers[i];
    }
    
    double answer = sum/len;
    return answer;
}