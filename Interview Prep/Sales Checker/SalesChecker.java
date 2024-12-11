import java.util.Scanner;

public class SalesChecker {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int tc = scanner.nextInt();
    while (tc-- > 0) {
      int M = scanner.nextInt();
      int R = scanner.nextInt();
      int D = scanner.nextInt();
      String result = solution(M, R, D);
      System.out.println(result);
    }
    scanner.close();
  }

  public static String solution(int M, int R, int D) {
    int initialSales = Math.min(M, D);
    int remainingDays = D - initialSales;
    int additionalSales = remainingDays;
    int maxSales = initialSales + additionalSales;
    return maxSales >= R ? "YES" : "NO";
  }
}
