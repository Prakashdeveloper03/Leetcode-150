import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
  public List<List<Integer>> combine(int n, int k) {
    List<List<Integer>> res = new ArrayList<>();
    List<Integer> comb = new ArrayList<>();
    backtrack(1, comb, res, n, k);
    return res;
  }

  private void backtrack(int start, List<Integer> comb, List<List<Integer>> res, int n, int k) {
    if (comb.size() == k) {
      res.add(new ArrayList<>(comb));
      return;
    }

    for (int num = start; num <= n; num++) {
      comb.add(num);
      backtrack(num + 1, comb, res, n, k);
      comb.remove(comb.size() - 1);
    }
  }
}

public class Combinations {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    while (tc-- > 0) {
      int n = sc.nextInt();
      int k = sc.nextInt();
      List<List<Integer>> result = obj.combine(n, k);
      for (List<Integer> nextList : result) {
        for (int x : nextList) {
          System.out.print(x + " ");
        }
        System.out.println();
      }
      System.out.println();
    }
    sc.close();
  }
}
