#include <iostream>
using namespace std;

int climbStairs(int n) {
  if (n < 0) {
    return 0;
  }
  if (n == 0 || n == 1) {
    return 1;
  }
  if (n == 2) {
    return 2;
  }
  int n1 = 1, n2 = 2, current = 0;
  for (int i = 2; i < n; ++i) {
    current = n1 + n2;
    n1 = n2;
    n2 = current;
  }
  return current;
}

int main() {
  int tc;
  cin >> tc;
  cin.ignore();
  for (int t = 0; t < tc; ++t) {
    int n;
    cin >> n;
    cin.ignore();
    cout << climbStairs(n) << endl;
  }
  return 0;
}
