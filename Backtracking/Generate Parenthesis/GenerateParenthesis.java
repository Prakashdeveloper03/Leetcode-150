import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
  public List<String> generateParenthesis(int n) {
    List<String> res = new ArrayList<>();
    recurse(res, 0, 0, "", n);
    return res;
  }

  public void recurse(List<String> res, int left, int right, String s, int n) {
    if (s.length() == n * 2) {
      res.add(s);
      return;
    }

    if (left < n) {
      recurse(res, left + 1, right, s + "(", n);
    }

    if (right < left) {
      recurse(res, left, right + 1, s + ")", n);
    }
  }
}

public class GenerateParenthesis {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    sc.nextLine();
    while (tc-- > 0) {
      int n = sc.nextInt();
      List<String> result = obj.generateParenthesis(n);
      for (String s : result) {
        System.out.print(s + " ");
      }
      System.out.println();
    }
    sc.close();
  }
}
