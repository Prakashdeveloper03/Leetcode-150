import java.util.HashMap;
import java.util.Scanner;

class Solution {
  public boolean isIsomorphic(String s, String t) {
    if (s.length() != t.length()) return false;
    HashMap<Character, Character> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      char sch = s.charAt(i);
      char tch = t.charAt(i);
      if (map.containsKey(sch)) {
        if (map.get(sch) != tch) {
          return false;
        }
      } else if (map.containsValue(tch)) {
        return false;
      } else {
        map.put(sch, tch);
      }
    }
    return true;
  }
}

public class Isomorphic {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    sc.nextLine();
    while (tc-- > 0) {
      String s = sc.nextLine();
      String t = sc.nextLine();
      System.out.println(obj.isIsomorphic(s, t));
    }
    sc.close();
  }
}
