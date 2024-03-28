#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;
    vector<int> clothes(n,1); //전체 학생들이 가지고 있는 옷 개수를 1로 초기화
    
    answer = n - lost.size();
    
    for (auto i : lost) {      //옷을 도난 당한 친구들의 옷 개수를 1 줄인다
        clothes[i-1]--;
    }
    for (auto i : reserve) {  //여분을 들고 온 친구들의 옷 개수를 1 늘린다.
        clothes[i-1]++;
        if(clothes[i-1] == 1) answer++;
    }
    for (int i = 0; i < clothes.size(); ++i) {
        cout << clothes[i];
    }
    cout << endl;

    for (int i = 0; i < n; ++i) {
        if(clothes[i] == 0) { //만약 옷이 없는 친구라면 앞과 뒤 친구를 조사해보자
            if(clothes[i-1] == 2) {
                if(i != 0) {
                    clothes[i-1]--;
                    clothes[i]++;
                    answer++;
                }
            }
            else if(clothes[i+1] == 2) {
                if(i != n-1) {
                    clothes[i+1]--;
                    clothes[i]++;
                    answer++;
                }
            }
        }
    }
    for (int i = 0; i < clothes.size(); ++i) {
        cout << clothes[i];
    }
    return answer;
}