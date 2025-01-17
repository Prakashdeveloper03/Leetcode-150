#include <iostream>
#include <sstream>
#include <stack>
#include <string>
#include <vector>
using namespace std;

class Solution {
 public:
  string simplifyPath(string path) {
    stack<string> st;
    stringstream ss(path);
    string segment;
    vector<string> paths;
    while (getline(ss, segment, '/')) {
      if (segment == ".." && !st.empty()) {
        st.pop();
      } else if (!segment.empty() && segment != "." && segment != "..") {
        st.push(segment);
      }
    }
    string result;
    while (!st.empty()) {
      result = "/" + st.top() + result;
      st.pop();
    }

    return result.empty() ? "/" : result;
  }
};

int main() {
  Solution obj;
  int tc;
  cin >> tc;
  cin.ignore();
  while (tc-- > 0) {
    string path;
    getline(cin, path);
    cout << obj.simplifyPath(path) << endl;
  }
  return 0;
}
