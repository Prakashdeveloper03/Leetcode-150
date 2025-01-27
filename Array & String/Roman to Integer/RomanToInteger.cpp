#include <iostream>
#include <string>
#include <unordered_map>
using namespace std;
class Solution {
 public:
  int romanToInt(string s) {
    unordered_map<char, int> mp;
    mp['I'] = 1;
    mp['V'] = 5;
    mp['X'] = 10;
    mp['L'] = 50;
    mp['C'] = 100;
    mp['D'] = 500;
    mp['M'] = 1000;
    int result = 0;
    int n = s.size();
    for (int i = 0; i < n; i++) {
      if (i < n - 1 && mp[s[i]] < mp[s[i + 1]]) {
        result += mp[s[i + 1]] - mp[s[i]];
        i++;
      } else {
        result += mp[s[i]];
      }
    }
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
    cout << obj.romanToInt(s) << endl;
  }
  return 0;
}