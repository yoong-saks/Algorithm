#include <string>
#include <vector>

using namespace std;

string solution(string new_id) {
    string answer = "";
    string temp_id = "";
    //1
    for(char c : new_id) {
        if(c >= 'A' && c <= 'Z') temp_id += c-'A'+'a';
        else temp_id += c;
    }
    
    new_id = temp_id;
    temp_id = "";
    //2
    for(char c : new_id) {
        if ((c >= 'a'&&c <= 'z') || (c >= '0' && c <= '9') || (c == '-') || (c == '_') || (c == '.')) 
            temp_id += c;
    }
    new_id = temp_id;
    temp_id = "";
    //3
    bool iter_sig = false;
    for(char c : new_id) {
        if(c == '.') {
            if(!iter_sig) {
                iter_sig ^= 1;
                temp_id += c;
            }
        }
        else {
            temp_id += c;
            iter_sig = false;
        }
    }
    new_id = temp_id;
    temp_id = "";
    //4
    if(new_id[0] =='.' || new_id[new_id.size()-1] == '.') {
        if(new_id[0] =='.') {
            temp_id.append(new_id,1,new_id.size()-1);
            new_id = temp_id;
            temp_id = "";
        }
        if(new_id[new_id.size()-1] == '.') {
            temp_id.append(new_id,0,new_id.size()-1);
            new_id = temp_id;
            temp_id = "";
        }
    }
    else {
        temp_id = new_id;
        new_id = temp_id;
    }
    temp_id = "";
    
    //5
    if(new_id == "") new_id = "a";
    
    //6
    if(new_id.size() >= 16) temp_id.append(new_id,0,15);
    else temp_id = new_id;
    if(temp_id[temp_id.size()-1] == '.') temp_id.pop_back();
    
    new_id = temp_id;
    temp_id = "";
    
    //7
    if(new_id.size() <= 2) {
        while(new_id.size() < 3) new_id.push_back(new_id[new_id.size()-1]);
    }
    
    answer = new_id;
    return answer;
}