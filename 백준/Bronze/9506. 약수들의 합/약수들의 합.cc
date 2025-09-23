#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

void print_value(vector<int> val) {
    
    for(int i = 0; i < val.size() - 1; i++) {
        cout << val[i];
        if(i != val.size() - 2) {
            cout << " + ";
        }
    }
}

int main() {
    cin.tie(NULL);
    ios_base::sync_with_stdio(false);
    
    int a;
    
    cin >> a;
    
    while(a != -1) {
        vector<int> divisors;
        
        for(int i = 1; i * i <= a; i++) {
            if(a % i == 0) {
                divisors.push_back(i);
                if(i * i != a) {
                    divisors.push_back(a / i);
                }
            } 
        }
        
        sort(divisors.begin(), divisors.end());
        int sum = 0;
        
        for(int i = 0; i < divisors.size() - 1; i++) {
            sum += divisors[i];
        }
        
        cout << a;
        if(sum == a) {
            cout << " = ";
            print_value(divisors);
        } else {
            cout << " is NOT perfect.";
        }
        cout << '\n';
        
        cin >> a;
    }
}