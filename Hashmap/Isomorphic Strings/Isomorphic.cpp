#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;

class Solution {
 public:
  bool isIsomorphic(string s, string t) {
    if (s.length() != t.length()) return false;
    unordered_map<char, char> mapST;
    unordered_map<char, char> mapTS;
    for (int i = 0; i < s.length(); i++) {
      char sch = s[i];
      char tch = t[i];
      if (mapST.count(sch)) {
        if (mapST[sch] != tch) return false;
      } else {
        mapST[sch] = tch;
      }
      if (mapTS.count(tch)) {
        if (mapTS[tch] != sch) return false;
      } else {
        mapTS[tch] = sch;
      }
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
    if (obj.isIsomorphic(s, t)) {
      cout << "true" << endl;
    } else {
      cout << "false" << endl;
    }
  }
  return 0;
}
