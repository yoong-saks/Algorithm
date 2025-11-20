#include <iostream>
#include <queue>
#include <string>

using namespace std;

struct IJT {
	int i, j, t;
};

int board[101][101];

int di[4] = { -1, 0, 1, 0 };
int dj[4] = { 0, 1, 0, -1 };

int main() {
	int N, M;

	cin >> N >> M;

	for (int i = 1; i <= N; ++i) {
		string s;

		cin >> s;

		for (int j = 1; j <= M; ++j) {

			board[i][j] = s[j - 1] - '0';
		}
	}

	queue<IJT> q;

	q.push({ 1, 1, 1 });
	board[1][1] = 0;

	while (!q.empty()) {
		IJT cur = q.front();
		q.pop();

		for (int d = 0; d < 4; ++d) {
			int ni = cur.i + di[d];
			int nj = cur.j + dj[d];

			if (!(1 <= ni && ni <= N)) continue;
			if (!(1 <= nj && nj <= M)) continue;
			if (board[ni][nj] == 0) continue;
			if (ni == N && nj == M) {
				cout << cur.t + 1 << endl;

				return 0;
			}

			board[ni][nj] = 0;
			q.push({ ni, nj, cur.t + 1 });
		}
	}

	return 0;
}