import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
  public boolean containsNearbyDuplicate(int[] nums, int k) {
    Map<Integer, Integer> seen = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int val = nums[i];
      if (seen.containsKey(val) && i - seen.get(val) <= k) {
        return true;
      }
      seen.put(val, i);
    }
    return false;
  }
}

public class Duplicate {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    while (tc-- > 0) {
      int n = sc.nextInt();
      int nums[] = new int[n];
      for (int i = 0; i < n; i++) {
        nums[i] = sc.nextInt();
      }
      int target = sc.nextInt();
      System.out.println(obj.containsNearbyDuplicate(nums, target));
    }
    sc.close();
  }
}
