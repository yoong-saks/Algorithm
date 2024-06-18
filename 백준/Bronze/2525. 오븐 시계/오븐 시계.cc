#include <iostream>
#include <vector>

using namespace std;

pair<int, int> numtopair(int n) {
	int hour = 0;
	int min = 0;
	while (1) {
		if (n >= 60) {
			hour += 1;
			n = n - 60;
		}
		else {
			min = n;
			break;
		}
	}
	pair<int, int> t = make_pair(hour, min);

	return t;
}

int main()
{
	pair<int, int> clock;
	cin >> clock.first >> clock.second;

	int number;
	cin >> number;

	pair<int, int> plustime = numtopair(number);

	clock.first = clock.first + plustime.first;
	clock.second = clock.second + plustime.second;

	int plus_h = 0;
	while (clock.second >= 60) {
		if (clock.second >= 60) {
			clock.second %= 60;
			plus_h += 1;
		}
	}
	
	clock.first += plus_h;

	if (clock.first >= 24) {
		clock.first %= 24;
	}

	cout << clock.first << " " << clock.second << endl;
}