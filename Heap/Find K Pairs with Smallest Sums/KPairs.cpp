#include <iostream>
#include <queue>
#include <vector>
using namespace std;
class Solution {
 public:
  vector<vector<int>> kSmallestPairs(vector<int>& nums1, vector<int>& nums2,
                                     int k) {
    priority_queue<tuple<int, int, int>, vector<tuple<int, int, int>>,
                   greater<>>
        minHeap;
    vector<vector<int>> result;
    for (int i = 0; i < nums1.size(); i++) {
      minHeap.emplace(nums1[i] + nums2[0], i, 0);
    }
    while (k-- > 0 && !minHeap.empty()) {
      auto [sum, pos1, pos2] = minHeap.top();
      minHeap.pop();
      result.push_back({nums1[pos1], nums2[pos2]});
      if (pos2 + 1 < nums2.size()) {
        minHeap.emplace(nums1[pos1] + nums2[pos2 + 1], pos1, pos2 + 1);
      }
    }
    return result;
  }
};

int main() {
  int tc;
  cin >> tc;
  Solution obj;
  while (tc-- > 0) {
    int n1;
    cin >> n1;
    vector<int> nums1(n1);
    for (int i = 0; i < n1; i++) {
      cin >> nums1[i];
    }
    int n2;
    cin >> n2;
    vector<int> nums2(n2);
    for (int i = 0; i < n2; i++) {
      cin >> nums2[i];
    }
    int k;
    cin >> k;
    vector<vector<int>> result = obj.kSmallestPairs(nums1, nums2, k);
    for (vector<int> x : result) {
      for (int y : x) {
        cout << y << " ";
      }
      cout << "\n";
    }
  }
  return 0;
}
