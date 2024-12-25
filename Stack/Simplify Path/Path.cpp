#include <iostream>
#include <sstream>
#include <stack>
#include <string>
using namespace std;

class Solution {
 public:
  string simplifyPath(string path) {
    stack<string> stack;
    string result;
    stringstream ss(path);
    string s;
    while (getline(ss, s, '/')) {
      if (s == "..") {
        if (!stack.empty()) stack.pop();
      } else if (!s.empty() && s != "." && s != "..") {
        stack.push(s);
      }
    }
    if (stack.empty()) return "/";
    while (!stack.empty()) {
      result = "/" + stack.top() + result;
      stack.pop();
    }
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
    cout << Solution().simplifyPath(s) << endl;
  }
  return 0;
}