package Problems.dynamicProgramming.tabulation;

import java.util.Arrays;

/**
 * Given a set of positive numbers, partition the set into two subsets with a
 * minimum difference between their subset sums.
 */

public class MinSubsetSumDifference {

    // T: O(N*Sum(N)), S: O(N*Sum(N))
    public int minimumDifference(int[] nums) {
        int totalSum = Arrays.stream(nums).sum();
        boolean[][] dp = new boolean[nums.length + 1][totalSum / 2 + 1];
        dp[0][0] = true;

        // 1) find all possible partitions up to totalSum/2
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

        // idle case is that both partition difference is zero
        // if we couldn't generate that, then we try to get the closest partition sum

        // 2) iterate from the last cell; bottom right
        int firstPartitionSum = 0;
        for (int sum = dp[0].length - 1; sum >= 0; sum--) {
            if (dp[dp.length - 1][sum]) {
                firstPartitionSum = sum;
                break;
            }
        }

        // 3) calculate the second partition sum and return the abs difference
        int secondPartitionSum = totalSum - firstPartitionSum;
        return Math.abs(firstPartitionSum - secondPartitionSum);

    }

    public static void main(String[] args) {
        MinSubsetSumDifference m = new MinSubsetSumDifference();
        System.out.println(m.minimumDifference(new int[] { 1, 2, 3, 9 }));
        System.out.println(m.minimumDifference(new int[] { 1, 2, 7, 1, 5 }));
        System.out.println(m.minimumDifference(new int[] { 1, 3, 100, 4 }));
    }
}
