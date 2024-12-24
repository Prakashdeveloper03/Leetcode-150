#include <iostream>
#include <sstream>
#include <stack>
#include <string>
#include <vector>
using namespace std;
class Solution {
 public:
  int evalRPN(vector<string>& tokens) {
    stack<int> stack;
    for (const string& s : tokens) {
      if (s == "+") {
        int val1 = stack.top();
        stack.pop();
        int val2 = stack.top();
        stack.pop();
        stack.push(val2 + val1);
      } else if (s == "-") {
        int val1 = stack.top();
        stack.pop();
        int val2 = stack.top();
        stack.pop();
        stack.push(val2 - val1);
      } else if (s == "*") {
        int val1 = stack.top();
        stack.pop();
        int val2 = stack.top();
        stack.pop();
        stack.push(val2 * val1);
      } else if (s == "/") {
        int val1 = stack.top();
        stack.pop();
        int val2 = stack.top();
        stack.pop();
        stack.push(val2 / val1);
      } else {
        stack.push(stoi(s));
      }
    }
    return stack.top();
  }
};

int main() {
  int tc;
  cin >> tc;
  cin.ignore();
  while (tc-- > 0) {
    int n;
    cin >> n;
    cin.ignore();
    vector<string> tokens;
    string line;
    getline(cin, line);
    stringstream ss(line);
    string token;
    while (ss >> token) {
      tokens.push_back(token);
    }
    cout << Solution().evalRPN(tokens) << endl;
  }
  return 0;
}
