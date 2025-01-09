#include <iostream>
#include <vector>
using namespace std;

int findLastNonZeroIndex(const vector<int>& arr) {
  for (int i = arr.size() - 1; i >= 0; --i) {
    if (arr[i] != 0) {
      return i;
    }
  }
  return -1;
}

int main() {
  int tc;
  cin >> tc;
  while (tc-- > 0) {
    int n;
    cin >> n;
    vector<int> arr(n);
    for (int i = 0; i < n; ++i) {
      cin >> arr[i];
    }
    int index = findLastNonZeroIndex(arr);
    cout << index << endl;
  }
  return 0;
}
