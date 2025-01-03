#include <algorithm>
#include <climits>
#include <iostream>
#include <vector>
using namespace std;

class Solution {
 public:
  int coinChange(vector<int>& coins, int amount) {
    vector<int> minCoins(amount + 1, INT_MAX - 1);
    minCoins[0] = 0;
    for (int c : coins) {
      for (int i = c; i <= amount; ++i) {
        if (minCoins[i - c] != INT_MAX - 1) {
          minCoins[i] = min(minCoins[i], minCoins[i - c] + 1);
        }
      }
    }
    return minCoins[amount] == INT_MAX - 1 ? -1 : minCoins[amount];
  }
};

int main() {
  int tc;
  cin >> tc;
  Solution obj;
  while (tc-- > 0) {
    int n;
    cin >> n;
    vector<int> coins(n);
    for (int i = 0; i < n; ++i) {
      cin >> coins[i];
    }
    int amount;
    cin >> amount;
    cout << obj.coinChange(coins, amount) << endl;
  }
  return 0;
}