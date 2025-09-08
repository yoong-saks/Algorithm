#include <iostream>
#include <unordered_map>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    unordered_map<string, float> um = {
        {"A+", 4.5}, {"A0", 4.0}, {"B+", 3.5},
        {"B0", 3.0}, {"C+", 2.5}, {"C0", 2.0},
        {"D+", 1.5}, {"D0", 1.0}, {"F", 0}
    };

    float ans = 0;
    float total_credit = 0;

    for(int i = 0; i < 20; i++) {
        string sub;
        float credit;
        string score;

        cin >> sub >> credit >> score;

        if(score == "P") continue;

        total_credit += credit;
        ans += um[score] * credit;
    }

    ans /= total_credit;

    cout << ans << '\n';
}