import java.util.Scanner;

class Solution {
  public boolean isPalindrome(int x) {
    int sign = (x > 0) ? 1 : -1;
    int rev_num = 0, num = x;
    while (num > 0) {
      rev_num = rev_num * 10 + num % 10;
      num = num / 10;
    }
    return (rev_num * sign) == x;
  }
}

public class Palindrome {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    while (tc-- > 0) {
      int x = sc.nextInt();
      System.out.println(obj.isPalindrome(x));
    }
    sc.close();
  }
}
