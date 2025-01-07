#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

class MaxProductOfFour {
 public:
  static long long maxProductOfFour(vector<int>& arr) {
    if (arr.size() < 4) {
      return -1;
    }
    sort(arr.begin(), arr.end());
    long long maxProduct1 = (long long)arr[arr.size() - 1] *
                            arr[arr.size() - 2] * arr[arr.size() - 3] *
                            arr[arr.size() - 4];
    long long maxProduct2 =
        (long long)arr[0] * arr[1] * arr[arr.size() - 1] * arr[arr.size() - 2];
    return max(maxProduct1, maxProduct2);
  }
};

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
    cout << MaxProductOfFour::maxProductOfFour(arr) << endl;
  }
  return 0;
}