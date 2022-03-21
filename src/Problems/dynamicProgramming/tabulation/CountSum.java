package Problems.dynamicProgramming.tabulation;

/**
 * Given a set of positive numbers, find the total number of subsets whose sum
 * is equal to a given number ‘S’.
 */

public class CountSum {
    public int countSubsets(int[] nums, int targetSum) {
        int[][] dp = new int[nums.length + 1][targetSum + 1];

        dp[0][0] = 1;

        for (int num = 1; num < dp.length; num++) {
            int currSum = nums[num - 1];
            for (int sum = 0; sum < dp[0].length; sum++) {
                // decision not to include
                dp[num][sum] = dp[num - 1][sum];

                // decision to include if less than sum
                if (currSum <= sum) {
                    dp[num][sum] += dp[num - 1][sum - currSum];
                }
            }
        }

        return dp[nums.length][targetSum];
    }

    public static void main(String[] args) {
        CountSum c = new CountSum();
        System.out.println(c.countSubsets(new int[] { 1, 1, 2, 3 }, 4));
        System.out.println(c.countSubsets(new int[] { 2, 3, 6, 7 }, 7));
        System.out.println(c.countSubsets(new int[] { 1, 2, 7, 1, 5 }, 9));
    }
}
