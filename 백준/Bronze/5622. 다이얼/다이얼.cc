#include <iostream>
using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);

    string s1;
    int ans = 0;

    cin >> s1;

    for(char c : s1) {
        switch(c) {
            case 'A' :
            case 'B' :
            case 'C' : 
                ans += 3;
                break;
            case 'D' :
            case 'E' :
            case 'F' :
                ans += 4;
                break;
            case 'G' :
            case 'H' :
            case 'I' :
                ans += 5;
                break;
            case 'J' :
            case 'K' :
            case 'L' :
                ans += 6;
                break;
            case 'M' :
            case 'N' :
            case 'O' :
                ans += 7;
                break;
            case 'P' :
            case 'Q' :
            case 'R' :
            case 'S' :
                ans += 8;
                break;
            case 'T' :
            case 'U' :
            case 'V' :
                ans += 9;
                break;
            case 'W' :
            case 'X' :
            case 'Y' :
            case 'Z' :
                ans += 10;
                break;
        }
    }

    cout << ans << '\n';
}