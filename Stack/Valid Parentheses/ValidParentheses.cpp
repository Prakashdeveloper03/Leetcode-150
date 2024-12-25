#include <iostream>
#include <stack>
#include <string>
using namespace std;
class Solution {
 public:
  bool isValid(string s) {
    stack<char> stack;
    for (char &c : s) {
      if (c == '{' || c == '[' || c == '(') {
        stack.push(c);
      } else {
        if (stack.empty()) {
          return false;
        }
        char top = stack.top();
        stack.pop();
        if (c == '}' && top != '{') return false;
        if (c == ']' && top != '[') return false;
        if (c == ')' && top != '(') return false;
      }
    }
    return stack.empty();
  }
};

int main() {
  int tc;
  cin >> tc;
  cin.ignore();
  while (tc-- > 0) {
    string s;
    getline(cin, s);
    cout << (Solution().isValid(s) ? "true" : "false") << endl;
  }
  return 0;
}