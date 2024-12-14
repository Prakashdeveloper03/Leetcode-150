import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

class Solution {
  public int removeDuplicates(int[] nums) {
    Map<Integer, Integer> hmap = new TreeMap<>();
    int n = 0;
    for (int num : nums) {
      hmap.put(num, hmap.getOrDefault(num, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : hmap.entrySet()) {
      int value = entry.getKey();
      int count = Math.min(entry.getValue(), 2);
      for (int i = 0; i < count; i++) {
        nums[n++] = value;
      }
    }
    return n;
  }
}

public class Duplicates2 {
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
