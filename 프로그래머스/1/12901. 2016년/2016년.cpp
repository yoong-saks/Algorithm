#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(int a, int b) {
    string answer = "";
    vector<int> m_days = {31,29,31,30,31,30,31,31,30,31,30,31};
    vector<string> dow = {"THU","FRI","SAT","SUN","MON","TUE","WED"};
    int days=0;
    for(int i=0;i<a; ++i) {
        days+=m_days[i];
    }
    days = days - m_days[a-1] + b;
    answer += dow[days%7];
    return answer;
}