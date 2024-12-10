import java.util.Scanner;

public class LastNonZeroIndex {
  public static int findLastNonZeroIndex(int[] arr) {
    for (int i = arr.length - 1; i >= 0; i--) {
      if (arr[i] != 0) {
        return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int tc = scanner.nextInt();
    while (tc-- > 0) {
      int n = scanner.nextInt();
      int[] arr = new int[n];
      for (int i = 0; i < n; i++) {
        arr[i] = scanner.nextInt();
      }
      int index = findLastNonZeroIndex(arr);
      System.out.println(index);
    }
    scanner.close();
  }
}
