import java.util.Scanner;

class Solution {
  public int maxProfit(int[] prices) {
    int l = 0, maxProfit = 0, profit = 0;
    for (int r = 1; r < prices.length; r++) {
      profit = prices[r] - prices[l];
      if (profit > 0) maxProfit = Math.max(profit, maxProfit);
      else l = r;
    }
    return maxProfit;
  }
}

public class MaxProfit {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    while (tc-- > 0) {
      int n = sc.nextInt();
      int[] prices = new int[n];
      for (int i = 0; i < n; i++) {
        prices[i] = sc.nextInt();
      }
      System.out.println(obj.maxProfit(prices));
    }
    sc.close();
  }
}
