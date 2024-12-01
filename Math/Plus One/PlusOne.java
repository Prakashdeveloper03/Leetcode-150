import java.util.Scanner;

class Solution {
  public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
      if (digits[i] + 1 != 10) {
        digits[i] += 1;
        return digits;
      }
      digits[i] = 0;
    }
    int[] newDigits = new int[digits.length + 1];
    newDigits[0] = 1;
    return newDigits;
  }
}

public class PlusOne {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    while (tc-- > 0) {
      int n = sc.nextInt();
      int digits[] = new int[n];
      for (int i = 0; i < n; i++) {
        digits[i] = sc.nextInt();
      }
      int[] result = obj.plusOne(digits);
      for (int x : result) System.out.printf("%d ", x);
      System.out.println();
    }
    sc.close();
  }
}
