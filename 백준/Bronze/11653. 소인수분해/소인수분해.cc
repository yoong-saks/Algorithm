#include <iostream>
#include <vector>
#include <cmath>
#include <algorithm>

using namespace std;

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int a;
    
    cin >> a;
    
    vector<bool> is_prime(10000001, 1);
    is_prime[1] = 0;
    
    for(int i = 2; i * i <= 10000001; i++){
        if(!is_prime[i]) continue;
        
        for(int j = 2; j * i <= 10000001; j++) {
            is_prime[i * j] = false;
        }
    }
    
    vector<int> ans;
    
    while(a > 1) {
        for(int i = 1; i < is_prime.size(); i++) {
            if(is_prime[i]) {
                if(a % i == 0) {
                    ans.push_back(i);
                    a /= i;
                    continue;
                }
            }
        }
    }
    
    sort(ans.begin(), ans.begin() + ans.size());
    
    for(int i : ans) {
        cout << i << '\n';
    }
}