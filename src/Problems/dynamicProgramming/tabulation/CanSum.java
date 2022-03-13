package Problems.dynamicProgramming.tabulation;

/*
 return true if 2 numbers in the array can sum up to the target number
*/

public class CanSum {

    public static boolean canSum(int targetSum, int[] nums) {
        boolean[] table = new boolean[targetSum + 1];
        table[0] = true;

        for (int i = 0; i < table.length; i++) {
            if (table[i] == true) {
                for (int num : nums) {
                    if (i + num < table.length) {
                        table[i + num] = true;
                    }
                }
            }
        }

        return table[targetSum];
    }

    public static boolean canSum2(int targetSum, int[] nums) {
        boolean[][] dp = new boolean[nums.length + 1][targetSum + 1];

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

        return dp[nums.length][targetSum];
    }

    public static void main(String[] args) {
        System.out.println(canSum2(6, new int[] { 1, 2, 3, 7 })); // true
        System.out.println(canSum2(7, new int[] { 2, 3,2 })); // true
        System.out.println(canSum2(7, new int[] { 2, 4 })); // false
        System.out.println(canSum2(8, new int[] { 2, 3, 5 })); // true
        System.out.println(canSum2(300, new int[] { 7, 14 })); // false
    }
}
