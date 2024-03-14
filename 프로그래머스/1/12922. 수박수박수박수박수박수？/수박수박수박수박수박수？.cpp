#include <string>
#include <vector>
#include <iostream>

using namespace std;

string solution(int n) {
    string answer = "";
    string water = "수";
    string melon = "박";
    for (int i=0; i<n; ++i) i%2==0?(answer.push_back(water[0]),answer.push_back(water[1]),answer.push_back(water[2])):(answer.push_back(melon[0]),answer.push_back(melon[1]),answer.push_back(melon[2]));
    return answer;
}