package Problems.dynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

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

    public static int getLongestSub(int[] nums) {
        PriorityQueue<int[]> maxPQ = new PriorityQueue<>((a, b) -> b[1] - a[1]);

        for (int num : nums) {
            int[] newEntry = new int[] { num, 1 };

            for (int[] entry : maxPQ) {
                // find the first number less than num
                if (entry[0] < num) {
                    newEntry[1] += entry[1];
                    break;
                }
            }

            maxPQ.add(newEntry);
        }

        if (maxPQ.isEmpty())
            return 0;

        int max = Integer.MIN_VALUE;
        for (int[] entry : maxPQ) {
            max = Math.max(max, entry[1]);
        }

        return max;
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence lSubsequence = new LongestIncreasingSubsequence();
        System.out.println(lSubsequence.getLongestSub(new int[] { 10, 9, 2, 5, 3, 7, 101, 18 }));
        System.out.println(lSubsequence.getLongestSub(new int[] { 0, 1, 0, 3, 2, 3 }));
        System.out.println(lSubsequence.getLongestSub(new int[] { 7, 7, 7, 7, 7, 7 }));
        System.out.println(lSubsequence.getLongestSub(new int[] { 2, 15, 3, 7, 8, 6, 18 }));
    }
}
