#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>
using namespace std;

void backtrack(const string& digits, int idx, string comb, vector<string>& res,
               const unordered_map<char, string>& digitToLetters) {
  if (idx == digits.length()) {
    res.push_back(comb);
    return;
  }

  string letters = digitToLetters.at(digits[idx]);
  for (char letter : letters) {
    backtrack(digits, idx + 1, comb + letter, res, digitToLetters);
  }
}

vector<string> letterCombinations(const string& digits) {
  vector<string> res;
  if (digits.empty()) {
    return res;
  }

  unordered_map<char, string> digitToLetters = {
      {'2', "abc"}, {'3', "def"},  {'4', "ghi"}, {'5', "jkl"},
      {'6', "mno"}, {'7', "pqrs"}, {'8', "tuv"}, {'9', "wxyz"}};

  backtrack(digits, 0, "", res, digitToLetters);
  return res;
}

int main() {
  int t;
  cin >> t;
  cin.ignore();
  for (int i = 0; i < t; ++i) {
    string digits;
    cin >> digits;
    vector<string> result = letterCombinations(digits);
    for (const auto& s : result) {
      cout << s << " ";
    }
    cout << endl;
  }
  return 0;
}
