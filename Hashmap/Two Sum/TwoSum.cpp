#include <iostream>
#include <unordered_map>
#include <vector>
using namespace std;

class Solution {
 public:
  vector<int> twoSum(vector<int>& nums, int target) {
    unordered_map<int, int> map;
    for (int i = 0; i < nums.size(); i++) {
      int complement = target - nums[i];
      if (map.find(complement) != map.end()) {
        return {map[complement], i};
      }
      map[nums[i]] = i;
    }
    return {};
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
    int target;
    cin >> target;
    vector<int> result = obj.twoSum(nums, target);
    if (!result.empty()) {
      for (int x : result) {
        cout << x << " ";
      }
      cout << endl;
    } else {
      cout << "No solution found!" << endl;
    }
  }
  return 0;
}
