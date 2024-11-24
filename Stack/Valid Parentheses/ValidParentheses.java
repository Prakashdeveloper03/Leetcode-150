import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

class Solution {
  public boolean isValid(String s) {
    Stack<Character> brackets = new Stack<>();
    Map<Character, Character> bracketLookup = new HashMap<>(3);
    bracketLookup.put(')', '(');
    bracketLookup.put('}', '{');
    bracketLookup.put(']', '[');
    for (char c : s.toCharArray()) {
      if (bracketLookup.containsKey(c)) {
        if (!brackets.isEmpty() && bracketLookup.get(c).equals(brackets.peek())) brackets.pop();
        else return false;
      } else {
        brackets.push(c);
      }
    }
    return brackets.isEmpty();
  }
}

public class ValidParentheses {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    sc.nextLine();
    while (tc-- > 0) {
      String s = sc.nextLine();
      System.out.println(obj.isValid(s));
    }
    sc.close();
  }
}
