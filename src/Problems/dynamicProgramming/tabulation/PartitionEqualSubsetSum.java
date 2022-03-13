package Problems.dynamicProgramming.tabulation;

import java.util.Arrays;

/**
 * Given a non-empty array nums containing only positive integers, find if the
 * array can be partitioned into two subsets such that the sum of elements in
 * both subsets is equal.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: nums = [1,5,11,5]
 * Output: true
 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
 */

public class PartitionEqualSubsetSum {

    public boolean canPartition(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        if (totalSum % 2 != 0) {
            return false;
        }

        boolean[][] dp = new boolean[nums.length + 1][(totalSum / 2) + 1];
        dp[0][0] = true;

        for (int num = 1; num < dp.length; num++) {
            int currSum = nums[num - 1];
            for (int sum = 0; sum < dp[0].length; sum++) {
                if (currSum > sum) {
                    dp[num][sum] = dp[num - 1][sum];
                } else {
                    dp[num][sum] = dp[num - 1][sum] || dp[num - 1][sum - currSum];
                }
            }
        }

        return dp[nums.length][totalSum / 2];
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        System.out.println(p.canPartition(new int[] { 1, 5, 11, 5 }));
    }
}
