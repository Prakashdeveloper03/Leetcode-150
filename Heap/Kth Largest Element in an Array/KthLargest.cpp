#include <iostream>
#include <queue>
#include <vector>
using namespace std;
class Solution {
 public:
  int findKthLargest(vector<int>& nums, int k) {
    priority_queue<int, vector<int>, greater<int>> minHeap;
    for (int x : nums) {
      minHeap.push(x);
      if (minHeap.size() > k) {
        minHeap.pop();
      }
    }
    return minHeap.top();
  }
};

int main() {
  int tc;
  cin >> tc;
  Solution obj;
  while (tc-- > 0) {
    int n;
    cin >> n;
    vector<int> nums(n);
    for (int i = 0; i < n; i++) {
      cin >> nums[i];
    }
    int k;
    cin >> k;
    cout << obj.findKthLargest(nums, k) << endl;
  }
  return 0;
}
