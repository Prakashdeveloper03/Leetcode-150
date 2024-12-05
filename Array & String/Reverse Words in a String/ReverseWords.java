import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
  public String reverseWords(String s) {
    return Arrays.stream(s.split(" "))
        .filter(word -> word.length() > 0)
        .collect(
            Collectors.collectingAndThen(
                Collectors.toList(),
                list -> {
                  Collections.reverse(list);
                  return list.stream();
                }))
        .collect(Collectors.joining(" "));
  }
}

public class ReverseWords {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    sc.nextLine();
    while (tc-- > 0) {
      String s = sc.nextLine();
      System.out.println(obj.reverseWords(s));
    }
    sc.close();
  }
}
