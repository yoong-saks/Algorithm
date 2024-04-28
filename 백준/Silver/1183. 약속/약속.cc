#include <vector>
#include <iostream>
#include <time.h>
#include <algorithm>

using namespace std;

int main() {
    int N; // 공대생의 수, 1 ~ 50
    cin >> N; // 공대생의 수를 입력받는다.

    vector<int> times(N); // 공대생의 약속 시간과 도착 시간의 차이를 저장할 벡터
    for (int i = 0; i < N; i++) { // 공대생의 수만큼 반복
        int a, b;
        cin >> a >> b; // 공대생의 약속 시간과 도착 시간을 입력받는다.
        times[i] = b - a; // 도착 시간 - 약속 시간을 저장한다.
    }

    sort(times.begin(), times.end()); // times 벡터를 오름차순으로 정렬한다.
    if(N % 2 == 0) {
        cout << times[N / 2] - times[N / 2 - 1] + 1 << endl; //
    } else {
        cout << 1 << endl;
    }
    
    return 0;
}