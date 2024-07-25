#include <iostream>

using namespace std;

int date_converter(int original) {
    return original - (2541 - 1998);
}

int main() {
    int input;
    
    cin >> input;
    cout << date_converter(input) << endl;
}