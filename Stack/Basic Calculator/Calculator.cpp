#include <iostream>
#include <stack>
#include <string>
using namespace std;

class Solution {
 public:
  int calculate(string s) {
    stack<int> st;
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
        st.push(result);
        st.push(sign);
        result = 0;
        sign = 1;
      } else if (c == ')') {
        result += sign * num;
        result *= st.top();
        st.pop();
        result += st.top();
        st.pop();
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
  Solution obj;
  while (tc-- > 0) {
    string s;
    getline(cin, s);
    cout << obj.calculate(s) << endl;
  }
  return 0;
}
