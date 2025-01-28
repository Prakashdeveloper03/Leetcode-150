#include <iostream>
using namespace std;
class Solution {
 public:
  bool isPalindrome(int x) {
    int sign = (x > 0) ? 1 : -1;
    int rev_num = 0, base_pos = 1, num = x;
    while (num > 0) {
      rev_num = rev_num * 10 + num % 10;
      num = num / 10;
    }
    return (rev_num * sign) == x;
  }
};

int main() {
  int tc;
  cin >> tc;
  Solution obj;
  while (tc-- > 0) {
    int x;
    cin >> x;
    cout << obj.isPalindrome(x) << " ";
    cout << endl;
  }
  return 0;
}