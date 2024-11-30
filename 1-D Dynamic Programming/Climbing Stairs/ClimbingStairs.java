import java.util.Scanner;

class Solution {
  public int climbStairs(int n) {
    if (n < 0) return 0;
    if (n == 0 || n == 1) return 1;
    if (n == 2) return 2;
    int n1 = 1, n2 = 2, current = 0;
    for (int i = 2; i < n; i++) {
      current = n1 + n2;
      n1 = n2;
      n2 = current;
    }
    return current;
  }
}

public class ClimbingStairs {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    while (tc-- > 0) {
      int n = sc.nextInt();
      System.out.println(obj.climbStairs(n));
    }
    sc.close();
  }
}
