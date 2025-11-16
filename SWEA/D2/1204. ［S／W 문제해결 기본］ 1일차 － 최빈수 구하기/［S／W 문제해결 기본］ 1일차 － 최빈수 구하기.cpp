#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void tc() {
    int T;
    vector<int> score(101, 0);

    cin >> T;

    int max = -1;
    
    for(int i = 0; i < 1000; ++i) {
        int student_score;

        cin >> student_score;

        score[student_score]++;

        if(max < score[student_score]) max = score[student_score];
    }
    int reverse_idx = find(score.rbegin(), score.rend(), max) - score.rbegin();
    
    cout << '#' << T << ' ' << score.size() - 1 - reverse_idx  << '\n';
}

int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        tc();
    }
}