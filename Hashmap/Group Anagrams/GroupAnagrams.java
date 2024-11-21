import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
  List<List<String>> groupAnagrams(List<String> strs) {
    Map<String, List<String>> ans = new HashMap<>();
    for (String s : strs) {
      char[] chars = s.toCharArray();
      Arrays.sort(chars);
      String key = new String(chars);
      ans.computeIfAbsent(key, k -> new ArrayList<>()).add(s);
    }

    List<List<String>> result = new ArrayList<>(ans.values());
    return result;
  }
}

public class GroupAnagrams {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    while (tc-- > 0) {
      int n = sc.nextInt();
      List<String> strs = new ArrayList<>();
      for (int i = 0; i < n; i++) {
        strs.add(sc.next());
      }
      List<List<String>> result = obj.groupAnagrams(strs);
      for (List<String> group : result) {
        for (String word : group) {
          System.out.print(word + " ");
        }
        System.out.println();
      }
      System.out.println();
    }
    sc.close();
  }
}
