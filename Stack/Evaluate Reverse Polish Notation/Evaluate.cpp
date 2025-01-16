#include <iostream>
#include <stack>
#include <string>
#include <vector>
using namespace std;

class Solution {
 public:
  int evalRPN(vector<string>& tokens) {
    stack<int> st;
    int val1, val2;
    for (const string& s : tokens) {
      if (s == "+") {
        int a = st.top();
        st.pop();
        int b = st.top();
        st.pop();
        st.push(b + a);
      } else if (s == "-") {
        int a = st.top();
        st.pop();
        int b = st.top();
        st.pop();
        st.push(b - a);
      } else if (s == "*") {
        int a = st.top();
        st.pop();
        int b = st.top();
        st.pop();
        st.push(b * a);
      } else if (s == "/") {
        int a = st.top();
        st.pop();
        int b = st.top();
        st.pop();
        st.push(b / a);
      } else {
        st.push(stoi(s));
      }
    }
    return st.top();
  }
};

int main() {
  int tc;
  cin >> tc;
  cin.ignore();
  Solution obj;
  while (tc-- > 0) {
    int n;
    cin >> n;
    cin.ignore();
    vector<string> tokens(n);
    for (int i = 0; i < n; i++) {
      getline(cin, tokens[i]);
    }
    cout << obj.evalRPN(tokens) << endl;
  }
  return 0;
}
