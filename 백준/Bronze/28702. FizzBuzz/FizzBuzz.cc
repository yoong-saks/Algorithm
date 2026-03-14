//problem No. 28702, FizzBuzz
#include <iostream>
#include <vector>
using namespace std;

int main()
{
	int n;
	string in[3];
	cin >> in[0] >> in[1] >> in[2];
	for (int i = 0; i < 3; i++) {
		if ((n = atoi(in[i].c_str())) != 0) {
			n += 3 - i;
			break;
		}
	}
	if (n % 15 == 0)
		cout << "FizzBuzz";
	else if (n % 3 == 0)
		cout << "Fizz";
	else if (n % 5 == 0)
		cout << "Buzz";
	else
		cout << n;
}