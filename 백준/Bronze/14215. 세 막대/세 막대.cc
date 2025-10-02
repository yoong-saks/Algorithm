#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    vector<int> a(3, 0);

    cin >> a[0] >> a[1] >> a[2];

    sort(a.begin(), a.end());

    if(a[2] >= a[0] + a[1]) {
        a[2] = a[0] + a[1] - 1;
    } 

    cout << a[0] + a[1] + a[2] << '\n';

}