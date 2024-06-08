#include <iostream>
#include <vector>

using namespace std;

int main(void) {
    int N, W; // 수열의 길이(1 <= N <= 50), 가중치 (0 <= W <= 100)
    
    cin >> N >> W; // 수열의 길이와 가중치 입력받기

    vector<int> n(N); // 수열을 저장할 벡터 생성
    
    int level[] = {1, 86, 172, 256}; // 레벨
    string code[] = {"00", "01", "10", "11"}; // 코드

    for(int i = 0; i < N; i++) { // 수열의 길이만큼 반복
        cin >> n[i]; // 수열 입력받기
    } 

    vector<vector<pair<int, string>>> v(4, vector<pair<int, string>>(2, {2147483647, ""})); // dp 테이블 생성
    for(int i = 0; i < 4; i++) { // 4번 반복
        v[i][0].first = abs(n[0] - level[i]) + W * 2;
        v[i][0].second = code[i];
    }

    bool toggle = 1;
    int count = 1;
    while(1) {
        if(count == N) break;
        else {
            for(int currentCode = 0; currentCode < 4; ++currentCode) {
                for(int search = 0; search < 4; ++search) {
                    auto before = v[search][!toggle];
                    auto current = v[currentCode][toggle];
                    if(currentCode == search) {
                        if(before.first + abs(n[count] - level[currentCode]) + W < current.first) {
                            v[currentCode][toggle] = {before.first + abs(n[count] - level[currentCode]) + W, before.second + '0'};
                        }
                    } else {
                        if(before.first + abs(n[count] - level[currentCode]) + W * 3 < current.first) {
                            v[currentCode][toggle] = {before.first + abs(n[count] - level[currentCode]) + W * 3, before.second + '1' + code[currentCode]};
                        }
                    }
                }
            }
            for(int i = 0; i < 4; i++) {
                v[i][!toggle].first = 2147483647;
            }

            toggle = !toggle;
            count++;
        }

    }

    int minNodeIndex = 0;
    for(int i = 1; i < 4; ++i) {
        if(v[i][!toggle] < v[minNodeIndex][!toggle]) minNodeIndex = i;
    }

    cout << v[minNodeIndex][!toggle].first << endl << v[minNodeIndex][!toggle].second << endl;
}