package Problems.dynamicProgramming.memoization;

import java.util.HashMap;
import java.util.Map;

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
    private Map<String, Boolean> cache = new HashMap<>();

    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        if (totalSum % 2 != 0) {
            return false;
        } else {
            return dfs(nums, totalSum / 2, 0);
        }
    }

    private boolean dfs(int[] nums, int sum, int index) {
        if (sum == 0) {
            return true;
        }

        if (index >= nums.length || sum < 0) {
            return false;
        }

        String key = sum + "," + index;

        if (cache.containsKey(key)) {
            return cache.get(key);
        }

        boolean result = dfs(nums, sum - nums[index], index + 1) || dfs(nums, sum, index + 1);

        cache.put(key, result);

        return result;
    }

    public static void main(String[] args) {
        PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
        p.canPartition(new int[] { 1, 5, 11, 5 });
    }
}
