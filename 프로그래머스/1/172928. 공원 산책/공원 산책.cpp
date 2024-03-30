#include <string>
#include <vector>

using namespace std;

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    int cur_x = 0;
    int cur_y = 0;
    for(int i = 0; i < park.size(); ++i) {
        for(int j = 0; j < park[i].size(); ++j) {
            if(park[i][j] == 'S') {
                cur_x = j;
                cur_y = i;
            }
        }
    }
    for(int i = 0; i < routes.size(); ++i) {
        switch (routes[i][0]) {
            case 'E':
                if (cur_x+stoi(routes[i].substr(2)) < park[0].size()) {
                    for(int j = 1; j <= stoi(routes[i].substr(2)); ++j) {
                        if(park[cur_y][cur_x+j] == 'X') break;
                        else if(j == stoi(routes[i].substr(2))) cur_x = cur_x+j; 
                    }
                }
                break;
            case 'W':
                if (cur_x-stoi(routes[i].substr(2)) > -1) {
                    for(int j = 1; j <= stoi(routes[i].substr(2)); ++j) {
                        if(park[cur_y][cur_x-j] == 'X') break;
                        else if(j == stoi(routes[i].substr(2))) cur_x = cur_x-j; 
                    }
                }
                break;
            case 'S':
                if (cur_y+stoi(routes[i].substr(2)) < park.size()) {
                    for(int j = 1; j <= stoi(routes[i].substr(2)); ++j) {
                        if(park[cur_y+j][cur_x] == 'X') break;
                        else if(j == stoi(routes[i].substr(2))) cur_y = cur_y+j; 
                    }
                }
                break;
            case 'N':
                if (cur_y-stoi(routes[i].substr(2)) > -1) {
                    for(int j = 1; j <= stoi(routes[i].substr(2)); ++j) {
                        if(park[cur_y-j][cur_x] == 'X') break;
                        else if(j == stoi(routes[i].substr(2))) cur_y = cur_y-j; 
                    }
                }
                break;
        }
    }
    answer.push_back(cur_y);
    answer.push_back(cur_x);

    return answer;
}