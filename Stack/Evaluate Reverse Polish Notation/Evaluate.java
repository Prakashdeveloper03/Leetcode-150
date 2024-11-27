import java.util.Scanner;
import java.util.Stack;

class Solution {
  public int evalRPN(String[] tokens) {
    Stack<Integer> stack = new Stack<>();
    int val1, val2;
    for (String s : tokens) {
      switch (s) {
        case "+":
          stack.push(stack.pop() + stack.pop());
          break;
        case "-":
          val1 = stack.pop();
          val2 = stack.pop();
          stack.push(val2 - val1);
          break;
        case "*":
          stack.push(stack.pop() * stack.pop());
          break;
        case "/":
          val1 = stack.pop();
          val2 = stack.pop();
          stack.push(val2 / val1);
          break;
        default:
          stack.push(Integer.parseInt(s));
      }
    }
    return stack.peek();
  }
}

public class Evaluate {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    sc.nextLine();
    while (tc-- > 0) {
      int n = sc.nextInt();
      sc.nextLine();
      String tokens[] = new String[n];
      for (int i = 0; i < n; i++) {
        tokens[i] = sc.nextLine();
      }
      System.out.println(obj.evalRPN(tokens));
    }
    sc.close();
  }
}
