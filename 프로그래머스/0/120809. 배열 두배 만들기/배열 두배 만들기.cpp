#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<int> numbers) {
    for(int& a:numbers) {
        a*=2;
    }
    return numbers;
}