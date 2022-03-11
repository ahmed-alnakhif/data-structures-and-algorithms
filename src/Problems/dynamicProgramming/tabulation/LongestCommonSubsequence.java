package Problems.dynamicProgramming.tabulation;

/**
 * Given two strings text1 and text2, return the length of their longest common
 * subsequence. If there is no common subsequence, return 0.
 * 
 * A subsequence of a string is a new string generated from the original string
 * with some characters (can be none) deleted without changing the relative
 * order of the remaining characters.
 * 
 * For example, "ace" is a subsequence of "abcde".
 * A common subsequence of two strings is a subsequence that is common to both
 * strings.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: text1 = "abcde", text2 = "ace"
 * Output: 3
 * Explanation: The longest common subsequence is "ace" and its length is 3.
 */

public class LongestCommonSubsequence {
    /**
     * approach:
     * if there's a match, then get the previous diagonal cell value (row-1, col-1) + 1
     * else, get the max between the upper cell and the left cell
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length() + 1;
        int m = text2.length() + 1;

        int[][] dp = new int[n][m];

        for (int col = 1; col < dp[0].length; col++) {
            for (int row = 1; row < dp.length; row++) {
                if (text1.charAt(row - 1) == text2.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                } else {
                    dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]);
                }
            }
        }

        return dp[n - 1][m - 1];
    }

    public static void main(String[] args) {
        LongestCommonSubsequence l = new LongestCommonSubsequence();
        System.out.println(l.longestCommonSubsequence("abcde", "ace"));
    }
}
