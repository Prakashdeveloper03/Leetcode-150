import java.util.Scanner;

public class MatrixToStringConversion {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    while (t-- > 0) {
      int M = scanner.nextInt();
      int N = scanner.nextInt();
      int[][] matrix = new int[M][N];
      for (int i = 0; i < M; i++) {
        for (int j = 0; j < N; j++) {
          matrix[i][j] = scanner.nextInt();
        }
      }
      String[] result = matrixToStringConversion(matrix, M, N);
      for (String row : result) {
        System.out.println(row);
      }
    }
    scanner.close();
  }

  public static String[] matrixToStringConversion(int[][] matrix, int M, int N) {
    String[] result = new String[M];
    for (int i = 0; i < M; i++) {
      StringBuilder rowString = new StringBuilder();
      for (int j = 0; j < N; j++) {
        if (matrix[i][j] == 0) {
          rowString.append('.');
        } else {
          rowString.append((char) (matrix[i][j] + 64));
        }
      }
      result[i] = rowString.toString();
    }
    return result;
  }
}
