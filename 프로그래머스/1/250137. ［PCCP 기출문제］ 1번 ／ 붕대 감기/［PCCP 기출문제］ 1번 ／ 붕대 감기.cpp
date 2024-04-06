#include <string>
#include <vector>

using namespace std;

int solution(vector<int> bandage, int health, vector<vector<int>> attacks) {
    int answer = 0;
    
    bool die = false;
    int cur_health = health;
    int combo = 0;
    int timeflow = 0;
    int attacks_cnt = 0;
    
    while(!die) {
        timeflow++;
        if(timeflow > attacks[attacks.size()-1][0]) break;
        if(attacks[attacks_cnt][0] == timeflow) {
            cur_health = cur_health - attacks[attacks_cnt][1];
            attacks_cnt++;
            combo = 0;
        }
        else if(cur_health <= health) {
            combo++;
            if(combo == bandage[0]) {
                (cur_health + bandage[2] + bandage[1] > health) ? (cur_health = health) : (cur_health=cur_health+bandage[2] + bandage[1]);
                combo = 0;
                continue;
            }
            (cur_health + bandage[1] > health) ? (cur_health = health) : (cur_health=cur_health+bandage[1]);

        }
        
        if (cur_health <= 0) die = true;
    }
    
    if(die == true) answer = -1;
    else answer = cur_health;
    return answer;
}