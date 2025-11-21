#include <iostream>

using namespace std;

struct IJ {
	int i, j;
};

int board[100][100];

int dj[4] = { 0, 1, 0, -1 };

int main() {
	for (int t = 1; t <= 10; ++t) {
		int T;

		cin >> T;

		IJ start_point;

		for (int i = 0; i < 100; ++i) {
			for (int j = 0; j < 100; ++j) {
				int tmp;

				cin >> tmp;

				board[i][j] = tmp;

				if (tmp == 2) start_point = { i, j };
			}
		}

		while (start_point.i != 0) {
			board[start_point.i][start_point.j] = 0;
			int ni = start_point.i - 1;

			// 좌우 탐색
			for (int d = 1; d <= 3; d = d + 2) {
				int nj;
				nj = start_point.j + dj[d];

				if (!(0 <= nj && nj < 100)) continue;
				if (board[start_point.i][nj] == 0) continue;

				start_point.j = nj;
				board[start_point.i][start_point.j] = 0;
			}

			if (board[ni][start_point.j]) start_point.i = ni;
		}

		cout << '#' << t << ' ' << start_point.j << endl;
	}

	return 0;
}