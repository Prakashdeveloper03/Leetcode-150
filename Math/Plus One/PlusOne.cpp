#include <iostream>
#include <vector>
using namespace std;

class Solution {
 public:
  vector<int> plusOne(vector<int>& digits) {
    for (int i = digits.size() - 1; i >= 0; i--) {
      if (digits[i] + 1 != 10) {
        digits[i] += 1;
        return digits;
      }
      digits[i] = 0;
    }
    vector<int> newDigits(digits.size() + 1, 0);
    newDigits[0] = 1;
    return newDigits;
  }
};

int main() {
  int tc;
  cin >> tc;
  Solution obj;
  while (tc-- > 0) {
    int n;
    cin >> n;
    vector<int> digits(n);
    for (int i = 0; i < n; i++) {
      cin >> digits[i];
    }
    vector<int> result = obj.plusOne(digits);
    for (int x : result) {
      cout << x << " ";
    }
    cout << endl;
  }
  return 0;
}
