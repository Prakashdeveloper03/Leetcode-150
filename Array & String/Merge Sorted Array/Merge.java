import java.util.Scanner;

class Solution {
  public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1, k = m + n - 1;
    while (j >= 0) {
      if (i >= 0 && nums1[i] > nums2[j]) nums1[k--] = nums1[i--];
      else nums1[k--] = nums2[j--];
    }
  }
}

public class Merge {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    while (tc-- > 0) {
      int m = sc.nextInt();
      int n = sc.nextInt();
      int[] nums1 = new int[m + n];
      for (int i = 0; i < m; i++) {
        nums1[i] = sc.nextInt();
      }
      int[] nums2 = new int[n];
      for (int j = 0; j < n; j++) {
        nums2[j] = sc.nextInt();
      }
      obj.merge(nums1, m, nums2, n);
      for (int x : nums1) {
        System.out.print(x + " ");
      }
      System.out.println();
    }
    sc.close();
  }
}
