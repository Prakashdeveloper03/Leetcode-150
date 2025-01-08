#include <iostream>
#include <string>
#include <vector>
using namespace std;

vector<string> matrixToStringConversion(const vector<vector<int>>& matrix,
                                        int M, int N) {
  vector<string> result(M);
  for (int i = 0; i < M; ++i) {
    string rowString;
    for (int j = 0; j < N; ++j) {
      if (matrix[i][j] == 0) {
        rowString += '.';
      } else {
        rowString += (char)(matrix[i][j] + 64);
      }
    }
    result[i] = rowString;
  }
  return result;
}

int main() {
  int t;
  cin >> t;
  while (t-- > 0) {
    int M, N;
    cin >> M >> N;
    vector<vector<int>> matrix(M, vector<int>(N));
    for (int i = 0; i < M; ++i) {
      for (int j = 0; j < N; ++j) {
        cin >> matrix[i][j];
      }
    }
    vector<string> result = matrixToStringConversion(matrix, M, N);
    for (const string& row : result) {
      cout << row << endl;
    }
  }
  return 0;
}
