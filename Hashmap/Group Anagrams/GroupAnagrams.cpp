#include <algorithm>
#include <iostream>
#include <string>
#include <unordered_map>
#include <vector>
using namespace std;

class Solution {
 public:
  vector<vector<string>> groupAnagrams(vector<string>& strs) {
    unordered_map<string, vector<string>> anagramGroups;
    for (const string& s : strs) {
      string sortedStr = s;
      sort(sortedStr.begin(), sortedStr.end());
      anagramGroups[sortedStr].push_back(s);
    }
    vector<vector<string>> result;
    for (const auto& group : anagramGroups) {
      result.push_back(group.second);
    }
    return result;
  }
};

int main() {
  Solution obj;
  int tc;
  cin >> tc;
  while (tc-- > 0) {
    int n;
    cin >> n;
    vector<string> strs(n);
    for (int i = 0; i < n; i++) {
      cin >> strs[i];
    }
    vector<vector<string>> result = obj.groupAnagrams(strs);
    cout << "Anagram groups:\n";
    for (const auto& group : result) {
      for (const string& word : group) {
        cout << word << " ";
      }
      cout << endl;
    }
    cout << endl;
  }
  return 0;
}
