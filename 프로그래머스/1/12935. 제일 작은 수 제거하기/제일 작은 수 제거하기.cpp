#include <string>
#include <vector>
#include <algorithm>

using namespace std;

vector<int> solution(vector<int> arr) {
    if (arr.size()!=1)arr.erase(min_element(arr.begin(),arr.end()));
    else arr[0] = -1;
    return arr;
}