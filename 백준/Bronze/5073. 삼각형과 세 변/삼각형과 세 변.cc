#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    vector<int> a(3, 0);

    cin >> a[0] >> a[1] >> a[2];

    while(a[0] + a[1] + a[2]) {
        sort(a.begin(), a.end());

        if(a[2] >= (a[0] + a[1])) {
            cout << "Invalid" << '\n';
        } else if(a[0] == a[1] && a[1] == a[2] && a[0] == a[2]) {
            cout << "Equilateral" << '\n';
        } else if(a[0] == a[1] || a[1] == a[2] || a[0] == a[2]) {
            cout << "Isosceles" << '\n';
        } else {
            cout << "Scalene" << '\n';
        }

        cin >> a[0] >> a[1] >> a[2];
    }

}