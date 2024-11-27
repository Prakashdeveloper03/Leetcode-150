import java.util.Scanner;
import java.util.Stack;

class Solution {
  public int calculate(String s) {
    Stack<Integer> stack = new Stack<>();
    int result = 0;
    int sign = 1;
    int num = 0;
    for (char c : s.toCharArray()) {
      if (Character.isDigit(c)) {
        num = num * 10 + (c - '0');
      } else if (c == '+') {
        result += sign * num;
        sign = 1;
        num = 0;
      } else if (c == '-') {
        result += sign * num;
        sign = -1;
        num = 0;
      } else if (c == '(') {
        stack.push(result);
        stack.push(sign);
        result = 0;
        sign = 1;
      } else if (c == ')') {
        result += sign * num;
        result *= stack.pop();
        result += stack.pop();
        num = 0;
      }
    }
    result += sign * num;
    return result;
  }
}

public class Calculator {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    sc.nextLine();
    while (tc-- > 0) {
      String s = sc.nextLine();
      System.out.println(obj.calculate(s));
    }
    sc.close();
  }
}
