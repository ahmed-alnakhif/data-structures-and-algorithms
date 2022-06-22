package Problems.dynamicProgramming;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int longest = 0;
        for (int c : dp) {
            longest = Math.max(longest, c);
        }

        return longest;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lSubsequence = new LongestIncreasingSubsequence();
        System.out.println(lSubsequence.lengthOfLIS(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
        System.out.println(lSubsequence.lengthOfLIS(new int[] { 0, 1, 0, 3, 2, 3 }));
        System.out.println(lSubsequence.lengthOfLIS(new int[] { 7, 7, 7, 7, 7, 7 }));
    }
}
