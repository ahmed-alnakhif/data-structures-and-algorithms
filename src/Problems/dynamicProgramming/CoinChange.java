package Problems.dynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;

public class CoinChange {

    //T: O(N * C), S: O(C)
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int num = 0; num < dp.length; num++) {
            for (int coin : coins) {
                if(num - coin >= 0){
                    dp[num] = Math.min(dp[num], 1 + dp[num - coin]);
                }
            }
        }

        return dp[amount] != Integer.MAX_VALUE ? dp[amount] : -1;
    }

    HashMap<Integer, Integer> cache;

    public int coinChange2(int[] coins, int amount) {
        cache = new HashMap<>();
        return minCoinChange(coins, amount);
    }

    private int minCoinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;
        if (cache.containsKey(amount)) return cache.get(amount);

        int minCoins = Integer.MAX_VALUE;

        for (int coin : coins) {
            int totalCoins = minCoinChange(coins, amount - coin);
            if (totalCoins >= 0 && totalCoins < minCoins) {
                minCoins = totalCoins + 1;
            }
        }

        minCoins = minCoins == Integer.MAX_VALUE ? -1 : minCoins;

        cache.put(amount, minCoins);

        return minCoins;
    }

    public static void main(String[] args) {

    }
}
