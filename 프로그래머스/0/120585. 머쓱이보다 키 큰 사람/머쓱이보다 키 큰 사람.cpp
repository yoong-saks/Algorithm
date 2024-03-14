#include <string>
#include <vector>

using namespace std;

int solution(vector<int> array, int height) {
    int answer = 0;
    for(int i=1;i<=array.size();i++)
    {
        if(height<array[array.size()-i]) answer++;
    }

    return answer;
}