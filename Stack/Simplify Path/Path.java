import java.util.Scanner;
import java.util.Stack;

class Solution {
  public String simplifyPath(String path) {
    Stack<String> stack = new Stack<>();
    StringBuilder result = new StringBuilder();
    String[] paths = path.split("/");
    for (String s : paths) {
      if (!stack.isEmpty() && s.equals("..")) {
        stack.pop();
      } else if (!s.equals("") && !s.equals(".") && !s.equals("..")) {
        stack.push(s);
      }
    }
    if (stack.isEmpty()) return "/";
    while (!stack.isEmpty()) {
      result.insert(0, stack.pop()).insert(0, "/");
    }
    return result.toString();
  }
}

public class Path {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    sc.nextLine();
    while (tc-- > 0) {
      String path = sc.nextLine();
      System.out.println(obj.simplifyPath(path));
    }
    sc.close();
  }
}
