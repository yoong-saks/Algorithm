//problem No. 14626, ISBN
#include <iostream>
#include <vector>
using namespace std;

int main()
{
	string s; cin >> s;
    int miss, sum = 0;
    for (int i = 0; i < 13; i++) {
        if (s[i] == '*') {
            miss = i;
            continue;
        }
        sum += (s[i] - '0') * (i % 2 == 0 ? 1 : 3);     
    }
    int dif = (10 - sum % 10) % 10;
    if (miss % 2 == 0) {
        cout << dif;
    } else {
        cout << ((3 - dif % 3) * 10 + dif) / 3 % 10;
    }
}