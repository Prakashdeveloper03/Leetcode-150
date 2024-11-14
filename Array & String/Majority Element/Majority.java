import java.util.Arrays;
import java.util.Scanner;

class Solution {
  public int majorityElement(int[] nums) {
    Arrays.sort(nums);
    return nums[nums.length / 2];
  }
}

public class Majority {
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
      System.out.println(obj.majorityElement(nums));
    }
    sc.close();
  }
}
