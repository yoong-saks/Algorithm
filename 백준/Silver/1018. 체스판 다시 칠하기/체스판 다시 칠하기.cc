#include <iostream>
#include <vector>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    vector<string> v;

    int board_vertical_size, board_horizontal_size;

    cin >> board_vertical_size >> board_horizontal_size;

    for(int i = 0; i < board_vertical_size; i++) {
        string usr_input;

        cin >> usr_input;
        
        v.push_back(usr_input);
    }

    int vertical_try = board_vertical_size - 8;
    int horizontal_try = board_horizontal_size - 8;

    int min_start_with_white = 100;
    int min_start_with_black = 100;

    for(int vt = 0; vt <= vertical_try; vt++) {
        for(int ht = 0; ht <= horizontal_try; ht++) {
            int start_with_white_board = 0;
            int start_with_black_board = 0;
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    if(((i + j) % 2) == 0) {
                        if(v[i + vt][j + ht] == 'B') {
                            start_with_white_board++;
                        } else if(v[i + vt][j + ht] == 'W') {
                            start_with_black_board++;
                        }
                    } else {
                        if(v[i + vt][j + ht] == 'B') {
                            start_with_black_board++;
                        } else if(v[i + vt][j +ht] == 'W') {
                            start_with_white_board++;
                        }
                    }
                }
            }

            if(min_start_with_white > start_with_white_board) {
                min_start_with_white = start_with_white_board;
            }
            if(min_start_with_black > start_with_black_board) {
                min_start_with_black = start_with_black_board;
            }
        }
    }

    if(min_start_with_black < min_start_with_white) {
        cout << min_start_with_black << '\n';
    } else {
        cout << min_start_with_white << '\n';
    }

}