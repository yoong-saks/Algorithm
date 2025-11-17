#include <iostream>
#include <vector>

using namespace std;

int sudoku[10][10];

bool row_valid() {
    for(int i = 1; i <= 9; ++i) {
        vector<bool> v(10, 0);

        for(int j = 1; j <= 9; ++j) {
            if(v[sudoku[i][j]]) return false;
            v[sudoku[i][j]] = 1;
        }
    }

    return true;
}

bool column_valid() {
    for(int i = 1; i <= 9; ++i) {
        vector<bool> v(10, 0);

        for(int j = 1; j <= 9; ++j) {
            if(v[sudoku[j][i]]) return false;
            v[sudoku[j][i]] = 1;
        }
    }
    
    return true;
}

bool block_valid() {
    
    for(int block_row = 1; block_row < 10; block_row += 3) {
        for(int block_col = 1; block_col < 10; block_col += 3) {
            int max = 0;
            vector<int> v(10, 0);

            for(int i = 0; i < 3; ++i) {
                for(int j = 0; j < 3; ++j) {
                    if(v[sudoku[block_row + i][block_col + j]]) return false;
                    v[sudoku[block_row + i][block_col + j]] = 1;
                }
            }

        }
    }

    return true;
}
int main() {
    int T;

    cin >> T;

    for(int t = 1; t <= T; ++t) {
        for(int i = 1; i <= 9; ++i) {
            for(int j = 1; j <= 9; ++j) {
                int tmp;
                cin >> tmp;

                sudoku[i][j] = tmp;
            }
        }

        int ans = row_valid() && column_valid() && block_valid();
        cout << '#' << t << ' ' << ans << '\n';

    }
}