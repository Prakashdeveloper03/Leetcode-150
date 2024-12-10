import java.util.Arrays;
import java.util.Scanner;

public class MaxProductOfFour {
  public static long maxProductOfFour(int[] arr) {
    if (arr.length < 4) {
      return -1;
    }
    Arrays.sort(arr);
    long maxProduct1 =
        (long) arr[arr.length - 1]
            * arr[arr.length - 2]
            * arr[arr.length - 3]
            * arr[arr.length - 4];
    long maxProduct2 = (long) arr[0] * arr[1] * arr[arr.length - 1] * arr[arr.length - 2];
    return Math.max(maxProduct1, maxProduct2);
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int tc = scanner.nextInt();
    while (tc-- > 0) {
      int n = scanner.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) arr[i] = scanner.nextInt();
      System.out.println(maxProductOfFour(arr));
    }
    scanner.close();
  }
}
