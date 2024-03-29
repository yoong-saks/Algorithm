#include <string>
#include <vector>
#include <iostream>
using namespace std;

int solution(vector<vector<int>> board, vector<int> moves) {
    int answer = 0;
    vector<int> stack= {-1};
    
    for(int i = 0; i < moves.size(); ++i) {
        for(int j = 0; j < board[0].size(); ++j) {
            if(board[j][moves[i]-1]) {
                if(board[j][moves[i]-1] == stack.back()) {
                    stack.pop_back();
                    answer+=2;
                } 
                else {
                    stack.push_back(board[j][moves[i]-1]);
                }
                board[j][moves[i]-1] = 0;
                break;
            }
        }
    }
    return answer;
}