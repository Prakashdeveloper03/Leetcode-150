import java.util.Scanner;

class Solution {
  public int[] productExceptSelf(int[] nums) {
    int[] output = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      output[i] = 1;
    }

    int left = 1;
    for (int i = 0; i < nums.length; i++) {
      output[i] *= left;
      left *= nums[i];
    }

    int right = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
      output[i] *= right;
      right *= nums[i];
    }

    return output;
  }
}

public class ProductExceptSelf {
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
      int result[] = obj.productExceptSelf(nums);
      for (int x : result) {
        System.out.printf("%d ", x);
      }
      System.out.println();
    }
    sc.close();
  }
}
