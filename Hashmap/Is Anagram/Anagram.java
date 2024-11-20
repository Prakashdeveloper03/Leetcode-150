import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class Solution {
  public boolean isAnagram(String s, String t) {
    if (s.length() != t.length()) return false;

    Map<Character, Integer> countMap = new HashMap<>();

    for (char c : s.toCharArray()) {
      countMap.put(c, countMap.getOrDefault(c, 0) + 1);
    }

    for (char c : t.toCharArray()) {
      if (!countMap.containsKey(c) || countMap.get(c) == 0) return false;
      countMap.put(c, countMap.get(c) - 1);
    }

    return true;
  }
}

public class Anagram {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    sc.nextLine();
    while (tc-- > 0) {
      String s = sc.nextLine();
      String t = sc.nextLine();
      System.out.println(obj.isAnagram(s, t));
    }
    sc.close();
  }
}
