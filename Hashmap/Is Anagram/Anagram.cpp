#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {
 public:
  bool isAnagram(string s, string t) {
    if (s.length() != t.length()) return false;
    unordered_map<char, int> countMap;
    for (char c : s) {
      countMap[c]++;
    }
    for (char c : t) {
      if (countMap.find(c) == countMap.end() || countMap[c] == 0) {
        return false;
      }
      countMap[c]--;
    }
    return true;
  }
};

int main() {
  Solution obj;
  int tc;
  cin >> tc;
  cin.ignore();
  while (tc-- > 0) {
    string s, t;
    getline(cin, s);
    getline(cin, t);
    if (obj.isAnagram(s, t)) {
      cout << "true" << endl;
    } else {
      cout << "false" << endl;
    }
  }
  return 0;
}
