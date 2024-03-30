#include <string>
#include <vector>

using namespace std;

string solution(vector<string> survey, vector<int> choices) {
    string answer = "";
    vector<int> score(4,4);
    for(int i = 0; i < survey.size(); ++i) {
        switch(survey[i][0]) {
            case 'R':
                score[0] += -1*(4 - choices[i]);
                break;
            case 'T':
                score[0] += (4 - choices[i]);
                break;
            case 'C':
                score[1] += -1*(4 - choices[i]);
                break;
            case 'F':
                score[1] += (4 - choices[i]);
                break;
            case 'J':
                score[2] += -1*(4 - choices[i]);
                break;
            case 'M':
                score[2] += (4 - choices[i]);
                break;
            case 'A':
                score[3] += -1*(4 - choices[i]);
                break;
            case 'N':
                score[3] += (4 - choices[i]);
                break;
        }
    }
    if(score[0] <= 4) answer += "R";
    else answer+= "T";
    if(score[1] <= 4) answer += "C";
    else answer+= "F";
    if(score[2] <= 4) answer += "J";
    else answer+= "M";
    if(score[3] <= 4) answer += "A";
    else answer+= "N";
    return answer;
}