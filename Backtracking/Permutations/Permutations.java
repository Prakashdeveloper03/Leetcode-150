import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
  public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> list = new ArrayList<>();
    backtrack(list, new ArrayList<>(), nums);
    return list;
  }

  private void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums) {
    if (tempList.size() == nums.length) {
      list.add(new ArrayList<>(tempList));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (tempList.contains(nums[i])) continue;
        tempList.add(nums[i]);
        backtrack(list, tempList, nums);
        tempList.remove(tempList.size() - 1);
      }
    }
  }
}

public class Permutations {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    while (tc-- > 0) {
      int n = sc.nextInt();
      int[] nums = new int[n];
      for (int i = 0; i < n; i++) {
        nums[i] = sc.nextInt();
      }
      List<List<Integer>> result = obj.permute(nums);
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
