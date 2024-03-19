#include <string>
#include <vector>
#include <iostream>

using namespace std;

int solution(vector<string> babbling) {
    int answer = 0;
    vector<string> do_word {"aya","ye","woo","ma"};

    for(int i = 0; i < babbling.size(); ++i) {
        if (babbling[i].size() <= 3) 
            for(int j = 0; j < do_word.size(); ++j)
                if(do_word[j] == babbling[i]) answer++;
        
        if(babbling[i].size() > 3) {
            vector<int> jump_cnt(4,0);
            bool isrepeat = false;
            string last_word="";
            for(int j = 0, jump = 0; j < babbling[i].size(); j+=jump) {
                if(babbling[i].substr(j,3) == do_word[0]) {
                    if(last_word == do_word[0]) {isrepeat = true; break;}
                    last_word = do_word[0];
                    jump = 3; ++jump_cnt[0];
                }
                else if(babbling[i].substr(j,2) == do_word[1]) {
                    if(last_word == do_word[1]) {isrepeat = true; break;}
                    last_word = do_word[1];
                    jump = 2; ++jump_cnt[1];
                }
                else if(babbling[i].substr(j,3) == do_word[2]) {
                    if(last_word == do_word[2]) {isrepeat = true; break;}
                    last_word = do_word[2];
                    jump = 3; ++jump_cnt[2];
                }
                else if(babbling[i].substr(j,2) == do_word[3]) {
                    if(last_word == do_word[3]) {isrepeat = true; break;}
                    last_word = do_word[3];
                    jump = 2; ++jump_cnt[3];
                }
                else {isrepeat = true; break;}
            }
            
            if(!isrepeat) answer++;
        }
    }
    return answer;
}