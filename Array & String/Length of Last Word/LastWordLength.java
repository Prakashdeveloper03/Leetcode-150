import java.util.Scanner;

class Solution {
  public int lengthOfLastWord(String s) {
    String[] words = s.trim().split(" ");
    return words[words.length - 1].length();
  }
}

public class LastWordLength {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    sc.nextLine();
    while (tc-- > 0) {
      String s = sc.nextLine();
      System.out.println(obj.lengthOfLastWord(s));
    }
    sc.close();
  }
}
