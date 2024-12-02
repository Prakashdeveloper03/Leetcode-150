import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

class Solution {
  public boolean isHappy(int n) {
    Set<Integer> visit = new HashSet<>();
    while (!visit.contains(n)) {
      visit.add(n);
      n = getNextNumber(n);
      if (n == 1) {
        return true;
      }
    }
    return false;
  }

  private int getNextNumber(int n) {
    int output = 0;
    while (n > 0) {
      int digit = n % 10;
      output += digit * digit;
      n = n / 10;
    }
    return output;
  }
}

public class HappyNumber {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    while (tc-- > 0) {
      int n = sc.nextInt();
      System.out.println(obj.isHappy(n));
    }
    sc.close();
  }
}
