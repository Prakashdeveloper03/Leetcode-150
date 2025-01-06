#include <iostream>
#include <string>
#include <vector>
using namespace std;

void recurse(vector<string>& res, int left, int right, string current, int n) {
  if (current.length() == n * 2) {
    res.push_back(current);
    return;
  }

  if (left < n) {
    recurse(res, left + 1, right, current + "(", n);
  }

  if (right < left) {
    recurse(res, left, right + 1, current + ")", n);
  }
}

vector<string> generateParenthesis(int n) {
  vector<string> res;
  recurse(res, 0, 0, "", n);
  return res;
}

int main() {
  int t;
  cin >> t;
  for (int i = 0; i < t; ++i) {
    int n;
    cin >> n;
    vector<string> result = generateParenthesis(n);
    for (const auto& s : result) {
      cout << s << " ";
    }
    cout << endl;
  }
  return 0;
}
