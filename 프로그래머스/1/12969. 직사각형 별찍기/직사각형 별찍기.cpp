#include <iostream>

using namespace std;

int main(void) {
    int a;
    int b;
    string s;

    cin >> a >> b;
    for (int i=0; i<a; ++i)
    {
        s+='*';
    }
    for (int i=0; i<b; ++i)
    {
        cout<< s << endl;
    }
    return 0;
}