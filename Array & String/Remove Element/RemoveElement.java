import java.util.Scanner;

class Solution {
  public int removeElement(int[] nums, int val) {
    int index = 0;
    for (int i = 0; i < nums.length; i++) {
      if (nums[i] != val) {
        nums[index] = nums[i];
        index++;
      }
    }
    return index;
  }
}

public class RemoveElement {
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
      int val = sc.nextInt();
      System.out.println(obj.removeElement(nums, val));
    }
    sc.close();
  }
}
