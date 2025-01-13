#include <iostream>
#include <stack>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {
 public:
  bool isValid(string s) {
    stack<char> brackets;
    unordered_map<char, char> bracketLookup;
    bracketLookup[')'] = '(';
    bracketLookup['}'] = '{';
    bracketLookup[']'] = '[';

    for (char c : s) {
      if (bracketLookup.find(c) != bracketLookup.end()) {
        if (!brackets.empty() && brackets.top() == bracketLookup[c]) {
          brackets.pop();
        } else {
          return false;
        }
      } else {
        brackets.push(c);
      }
    }
    return brackets.empty();
  }
};

int main() {
  Solution obj;
  int tc;
  cin >> tc;
  cin.ignore();
  while (tc-- > 0) {
    string s;
    getline(cin, s);
    cout << (obj.isValid(s) ? "True" : "False") << endl;
  }
  return 0;
}
