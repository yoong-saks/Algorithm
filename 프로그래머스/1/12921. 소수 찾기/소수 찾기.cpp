#include <string>
#include <vector>
#include <cstring>

using namespace std;

bool arr[1000001];
int solution(int n) {
    int answer = 0;
    memset(arr, true, sizeof(arr));
    
    for(int i = 2; i < sizeof(arr); ++i) {
        if (!arr[i]) continue;
        for (int j = i*2; j <= sizeof(arr); j += i) {
            arr[j] = false;
        }
    }
    
    for(int i = 2; i <= n; ++i) {
        if(arr[i]) answer++;
    }
    return answer;
}