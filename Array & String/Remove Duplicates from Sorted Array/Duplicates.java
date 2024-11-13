import java.util.Scanner;

class Solution {
  public int removeDuplicates(int[] nums) {
    int j = 1;
    for (int i = 1; i < nums.length; i++) {
      if (nums[i] != nums[i - 1]) {
        nums[j] = nums[i];
        j++;
      }
    }
    return j;
  }
}

public class Duplicates {
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
      int unique = obj.removeDuplicates(nums);
      for (int i = 0; i < unique; i++) System.out.printf("%d ", nums[i]);
      System.out.println();
    }
    sc.close();
  }
}
