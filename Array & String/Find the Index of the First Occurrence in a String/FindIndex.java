import java.util.Scanner;

class Solution {
  public int strStr(String haystack, String needle) {
    for (int i = 0, j = needle.length(); j <= haystack.length(); i++, j++) {
      if (haystack.substring(i, j).equals(needle)) {
        return i;
      }
    }
    return -1;
  }
}

public class FindIndex {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    sc.nextLine();
    while (tc-- > 0) {
      String haystack = sc.nextLine();
      sc.nextLine();
      String needle = sc.nextLine();
      System.out.println(obj.strStr(haystack, needle));
    }
    sc.close();
  }
}
