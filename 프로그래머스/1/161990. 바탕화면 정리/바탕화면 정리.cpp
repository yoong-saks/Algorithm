#include <string>
#include <vector>
#include <iostream>
using namespace std;

vector<int> solution(vector<string> wallpaper) {
    vector<int> answer;
    int lux = 51, luy = 51, rdx = -1, rdy = -1;
    for(int i = 0; i < wallpaper.size(); ++i) {
        for(int j = 0; j < wallpaper[0].size(); ++j) {
            if(wallpaper[i][j] == '#') {
                if(luy > i) luy = i;
                if(lux > j) lux = j;
                if(rdy < i+1) rdy = i+1;
                if(rdx < j+1) rdx = j+1;
            }
        }
    }
    answer = {luy, lux, rdy, rdx};
    return answer;
}