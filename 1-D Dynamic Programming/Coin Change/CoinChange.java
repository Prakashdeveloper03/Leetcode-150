import java.util.Arrays;
import java.util.Scanner;

class Solution {
  public int coinChange(int[] coins, int amount) {
    int[] minCoins = new int[amount + 1];
    Arrays.fill(minCoins, Integer.MAX_VALUE - 1);
    minCoins[0] = 0;
    for (int c : coins) {
      for (int i = c; i <= amount; i++) {
        if (minCoins[i - c] != Integer.MAX_VALUE - 1) {
          minCoins[i] = Math.min(minCoins[i], minCoins[i - c] + 1);
        }
      }
    }
    return minCoins[amount] == Integer.MAX_VALUE - 1 ? -1 : minCoins[amount];
  }
}

public class CoinChange {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Solution obj = new Solution();
    int tc = sc.nextInt();
    while (tc-- > 0) {
      int n = sc.nextInt();
      int coins[] = new int[n];
      for (int i = 0; i < n; i++) {
        coins[i] = sc.nextInt();
      }
      int amount = sc.nextInt();
      System.out.println(obj.coinChange(coins, amount));
    }
    sc.close();
  }
}
