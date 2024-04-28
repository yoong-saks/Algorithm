#include <vector>
#include <iostream>
#include <time.h>

using namespace std;

int main() {
    int N; // 사각형의 수, 1 <= N < 1000
    cin >> N; // 사각형의 수를 입력받는다.

    vector<pair<int, int>> rectangles(N); // 사각형의 너비와 높이를 저장할 벡터
    vector<int> minL(N + 1, 0); // 사각형의 짧은 길이를 저장할 벡터
    vector<int> maxL(N + 1, 0); // 사각형의 긴 길이를 저장할 벡터
    for (int i = 0; i < N; i++) { // 사각형의 수만큼 반복
        int w, h;
        cin >> w >> h; // 사각형의 너비와 높이를 입력받는다.
        rectangles[i] = {w, h}; // 너비와 높이를 저장한다.
    }

    clock_t start = clock(); // 코드가 시작된 시간 저장

    minL[0] = min(rectangles[0].first, rectangles[0].second); // 첫 번째 사각형의 짧은 길이는 첫 번째 사각형의 너비와 높이 중 작은 값이다.
    maxL[0] = max(rectangles[0].first, rectangles[0].second); // 첫 번째 사각형의 긴 길이는 첫 번째 사각형의 너비와 높이 중 큰 값이다.
    for(int i = 1; i < N; i++) { // 두 번째 사각형부터 마지막 사각형까지 반복
        int l = max(rectangles[i - 1].first, rectangles[i - 1].second);
        int L = max(rectangles[i].first, rectangles[i].second);
        int s = min(rectangles[i - 1].first, rectangles[i - 1].second);
        int S = min(rectangles[i].first, rectangles[i].second);

        minL[i] = max(minL[i - 1] + abs(L - l) + S, maxL[i - 1] + abs(L - s) + S); // 짧은 길이는 이전 사각형의 짧은 길이와 긴 길이 중 큰 값에 이전 사각형의 긴 길이와 현재 사각형의 짧은 길이의 차이와 현재 사각형의 짧은 길이를 더한 값과 이전 사각형의 긴 길이와 현재 사각형의 짧은 길이의 차이와 현재 사각형의 짧은 길이를 더한 값 중 큰 값이다.
        maxL[i] = max(minL[i - 1] + abs(S - l) + L, maxL[i - 1] + abs(S - s) + L); // 긴 길이는 이전 사각형의 짧은 길이와 긴 길이 중 큰 값에 이전 사각형의 짧은 길이와 현재 사각형의 긴 길이의 차이와 현재 사각형의 짧은 길이를 더한 값과 이전 사각형의 긴 길이와 현재 사각형의 짧은 길이의 차이와 현재 사각형의 짧은 길이를 더한 값 중 큰 값이다.
    }
    
    cout << max(minL[N - 1], maxL[N - 1]) << endl; // 최대 윗둘레의 길이를 출력한다.
    return 0;
}
