#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {


	for (int t = 1; t <= 10; ++t) {

		int T;

		cin >> T;

		vector<vector<int>> acum_vert(101, vector<int>(101, 0));
		vector<vector<int>> acum_hori(101, vector<int>(101, 0));
		vector<int> acum_diag1(101, 0);
		vector<int> acum_diag2(101, 0);

		for (int i = 1; i <= 100; ++i) {
			for (int j = 1; j <= 100; ++j) {
				int tmp;

				cin >> tmp;

				acum_vert[i][j] = acum_vert[i][j - 1] + tmp;
				acum_hori[i][j] = acum_hori[i - 1][j] + tmp;

				if (i == j) acum_diag1[i] = acum_diag1[i - 1] + tmp;
				if (i + j == 101) acum_diag2[i] = acum_diag2[i - 1] + tmp;
			}
		}

		int ans = 0;
		for (int i = 1; i <= 100; ++i) {
			int cur_max = max(acum_hori[100][i], acum_vert[i][100]);

			ans = max(ans, cur_max);
		}

		ans = max(ans, max(acum_diag1[100], acum_diag2[100]));

		cout << '#' << t << ' ' << ans << endl;
	}

	return 0;
}