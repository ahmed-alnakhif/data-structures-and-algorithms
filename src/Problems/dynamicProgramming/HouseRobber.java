package Problems.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * You are a professional robber planning to rob houses along a street. Each
 * house has a certain amount of money stashed, the only constraint stopping you
 * from robbing each of them is that adjacent houses have security systems
 * connected and it will automatically contact the police if two adjacent houses
 * were broken into on the same night.
 * 
 * Given an integer array nums representing the amount of money of each house,
 * return the maximum amount of money you can rob tonight without alerting the
 * police.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1]
 * Output: 4
 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
 * Total amount you can rob = 1 + 3 = 4.
 * Example 2:
 * 
 * Input: nums = [2,7,9,3,1]
 * Output: 12
 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5
 * (money = 1).
 * Total amount you can rob = 2 + 9 + 1 = 12.
 */

public class HouseRobber {

    Map<Integer, Integer> map = new HashMap<>();

    public int rob(int[] houses) {
        return robMemo(houses.length - 1, houses);
    }

    private int robMemo(int i, int[] houses) {
        if (i == 0) return houses[0];
        if (i == 1) return Math.max(houses[0], houses[1]);
        if (map.containsKey(i)) return map.get(i);

        map.put(i, Math.max(robMemo(i - 1, houses), robMemo(i - 2, houses) + houses[i]));

        return map.get(i);
    }

    public int robTab(int[] houses) {
        if (houses.length == 1) return houses[0];

        int[] dp = new int[houses.length];

        // Base cases
        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);

        // Recurrence relation
        for (int i = 2; i < houses.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + houses[i]); 
        }

        return dp[houses.length - 1];
    }

    public static void main(String[] args) {
        HouseRobber hr = new HouseRobber();
        int[] houses = { 1, 2, 3, 1 };
        System.out.println(hr.rob(houses));
        System.out.println(hr.robTab(houses));
    }
}
