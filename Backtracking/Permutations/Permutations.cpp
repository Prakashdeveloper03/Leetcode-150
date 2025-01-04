#include <algorithm>
#include <iostream>
#include <vector>
using namespace std;

bool contains(const vector<int>& slice, int num) {
  return find(slice.begin(), slice.end(), num) != slice.end();
}

void backtrack(vector<vector<int>>* result, vector<int> tempList,
               const vector<int>& nums) {
  if (tempList.size() == nums.size()) {
    result->push_back(tempList);
    return;
  }
  for (int i = 0; i < nums.size(); ++i) {
    if (contains(tempList, nums[i])) {
      continue;
    }
    tempList.push_back(nums[i]);
    backtrack(result, tempList, nums);
    tempList.pop_back();
  }
}

vector<vector<int>> permute(const vector<int>& nums) {
  vector<vector<int>> result;
  backtrack(&result, {}, nums);
  return result;
}

int main() {
  int t;
  cin >> t;

  for (int i = 0; i < t; ++i) {
    int n;
    cin >> n;
    vector<int> nums(n);
    for (int j = 0; j < n; ++j) {
      cin >> nums[j];
    }
    vector<vector<int>> result = permute(nums);
    for (const auto& nextList : result) {
      for (const auto& x : nextList) {
        cout << x << " ";
      }
      cout << endl;
    }
  }

  return 0;
}
