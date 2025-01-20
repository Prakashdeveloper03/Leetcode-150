#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

class Solution {
 public:
  bool containsNearbyDuplicate(vector<int>& nums, int k) {
    unordered_map<int, int> seen;
    for (int i = 0; i < nums.size(); i++) {
      int val = nums[i];
      if (seen.find(val) != seen.end() && i - seen[val] <= k) {
        return true;
      }
      seen[val] = i;
    }
    return false;
  }
};

int main() {
  Solution obj;
  int tc;
  cin >> tc;
  while (tc-- > 0) {
    int n;
    cin >> n;
    vector<int> nums(n);
    for (int i = 0; i < n; i++) {
      cin >> nums[i];
    }
    int k;
    cin >> k;
    cout << (obj.containsNearbyDuplicate(nums, k) ? "true" : "false") << endl;
  }
  return 0;
}