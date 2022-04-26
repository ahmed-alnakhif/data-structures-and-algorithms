package Problems.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given an integer array nums. You want to maximize the number of
 * points you get by performing the following operation any number of times:
 * 
 * Pick any nums[i] and delete it to earn nums[i] points. Afterwards, you must
 * delete every element equal to nums[i] - 1 and every element equal to nums[i]
 * + 1.
 * Return the maximum number of points you can earn by applying the above
 * operation some number of times.
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [3,4,2]
 * Output: 6
 * Explanation: You can perform the following operations:
 * - Delete 4 to earn 4 points. Consequently, 3 is also deleted. nums = [2].
 * - Delete 2 to earn 2 points. nums = [].
 * You earn a total of 6 points.
 */

public class DeleteAndEarn {

    private Map<Integer, Integer> points = new HashMap<>();
    private Map<Integer, Integer> cache = new HashMap<>();

    public int deleteAndEarnMemo(int[] nums) {
        int maxNum = 0;

        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            points.put(num, points.getOrDefault(num, 0) + num);
        }

        return maxPoints(maxNum);
    }

    private int maxPoints(int num) {
        if(num == 0) return 0;
        if(num == 1) return points.getOrDefault(1, 0);
        if(cache.containsKey(num)) return cache.get(num);

        // Recurrence relation
        int gain = points.getOrDefault(num, 0);
        cache.put(num, Math.max(maxPoints(num-1), maxPoints(num-2) + gain));
        return cache.get(num);
    }

    public int deleteAndEarnTab(int[] nums) {
        int maxNum = 0;

        for (int num : nums) {
            maxNum = Math.max(maxNum, num);
            points.put(num, points.getOrDefault(num, 0) + num);
        }

        int[] dp = new int[maxNum + 1];

        // Base cases
        dp[0] = 0;
        dp[1] = points.getOrDefault(1, 0);

        // Recurrence relation
        for (int i = 2; i <= maxNum; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + points.getOrDefault(i, 0));
        }

        return dp[maxNum];
    }



    public static void main(String[] args) {
        DeleteAndEarn dae = new DeleteAndEarn();
        int[] nums = { 3, 4, 2 };
        System.out.println(dae.deleteAndEarnTab(nums));
    }
}
