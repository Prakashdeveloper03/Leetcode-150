#include <iostream>
#include <stack>
#include <string>
using namespace std;

class Solution {
 public:
  int calculate(string s) {
    stack<int> stack;
    int result = 0;
    int sign = 1;
    int num = 0;

    for (char c : s) {
      if (isdigit(c)) {
        num = num * 10 + (c - '0');
      } else if (c == '+') {
        result += sign * num;
        sign = 1;
        num = 0;
      } else if (c == '-') {
        result += sign * num;
        sign = -1;
        num = 0;
      } else if (c == '(') {
        stack.push(result);
        stack.push(sign);
        result = 0;
        sign = 1;
      } else if (c == ')') {
        result += sign * num;
        result *= stack.top();
        stack.pop();
        result += stack.top();
        stack.pop();
        num = 0;
      }
    }

    result += sign * num;
    return result;
  }
};

int main() {
  int tc;
  cin >> tc;
  cin.ignore();
  while (tc-- > 0) {
    string s;
    getline(cin, s);
    cout << Solution().calculate(s) << endl;
  }
  return 0;
}
