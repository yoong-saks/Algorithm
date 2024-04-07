#include <string>
#include <vector>
#include <iostream>
#include <sstream>

using namespace std;

string solution(string s) {
    string answer = "";
    istringstream iss(s);
    ostringstream oss;
    
    int num;
    iss >> num;
    
    int max = num;
    int min = num;
    
    while(iss >> num) {
        if(min > num) min = num;
        if(max < num) max = num;
    }
    
    oss << min << " " << max;
    answer = oss.str();
    
    return answer;
}