#include <string>
#include <vector>

using namespace std;

int solution(int n, int m, vector<int> section) {
    int answer = 0;
    vector<bool> walls(n,0);
    for(int i = 0; i < section.size(); ++i) {
        walls[section[i]-1] = true;
    }
    
    for(int i = 0; i < walls.size(); ++i) {
        if(walls[i]) {
            for(int j = 0; j < m; ++j) {
                if (i+j < walls.size()) walls[i+j] = true;
            }
            answer++;
            i += m-1;
        }
    }
    return answer;
}