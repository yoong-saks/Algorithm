#include <string>
#include <vector>

using namespace std;

string solution(string phone_number) {
    string answer = "";
    int lens = phone_number.size();
    for (int i=0; i<=lens-5;i++) answer.push_back('*');
    for (int i=0; i<=3; i++) answer.push_back(phone_number[lens-4+i]);
    return answer;
}