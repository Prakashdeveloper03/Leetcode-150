#include <iostream>
#include <string>
using namespace std;

string solution(int M, int R, int D) {
  int initialSales = min(M, D);
  int remainingDays = D - initialSales;
  int additionalSales = remainingDays;
  int maxSales = initialSales + additionalSales;
  return maxSales >= R ? "YES" : "NO";
}

int main() {
  int tc;
  cin >> tc;
  while (tc-- > 0) {
    int M, R, D;
    cin >> M >> R >> D;
    string result = solution(M, R, D);
    cout << result << endl;
  }
  return 0;
}